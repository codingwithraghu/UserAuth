package org.scaler.userauthservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class User extends BaseModel {

    private String email;
    private String hashedPassword;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> role;
}
