package com.example.springsecurity_Login.controller;

import com.example.springsecurity_Login.entity.User;
import com.example.springsecurity_Login.event.RegistrationCompleteEvent;
import com.example.springsecurity_Login.model.UserModel;
import com.example.springsecurity_Login.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegistrationController {

    private UserService userService;

    private ApplicationEventPublisher publisher;


    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel){
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(
                  user,
                "url"
        ));
        return "SUCCESS";
    }
}
