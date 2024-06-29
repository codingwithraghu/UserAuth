package org.scaler.userauthservice.Services;

import org.scaler.userauthservice.Repository.UserRepo;
import org.scaler.userauthservice.dto.LoginRequestDto;
import org.scaler.userauthservice.dto.SignUpRequestDto;
import org.scaler.userauthservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepository;

    public User signUp(SignUpRequestDto signUpRequestDto) {

        User user = new User();
        user.setEmail(signUpRequestDto.getEmail());
        user.setName(signUpRequestDto.getName());
        user.setHashedPassword(signUpRequestDto.getPassword());

        User userResponse = userRepository.save(user);
        return userResponse;
    }

    public User login(LoginRequestDto loginRequestDto) {
        Optional<User> user = userRepository.findByEmail(loginRequestDto.getEmail());
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        if (!user.get().getHashedPassword().equals(loginRequestDto.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return user.get();
    }
}
