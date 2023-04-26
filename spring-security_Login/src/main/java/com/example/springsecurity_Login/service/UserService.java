package com.example.springsecurity_Login.service;

import com.example.springsecurity_Login.entity.User;
import com.example.springsecurity_Login.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);
}
