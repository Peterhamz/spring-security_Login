package com.example.springsecurity_Login.model;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @Id
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String matchingPassword;

}
