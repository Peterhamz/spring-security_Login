package com.example.springsecurity_Login.event.listener;

import com.example.springsecurity_Login.entity.User;
import com.example.springsecurity_Login.event.RegistrationCompleteEvent;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class RegistrationCompleteEventListener implements
        ApplicationListener<RegistrationCompleteEvent> {

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //create the verification token for the user with link
        User user = event.getUser();

        String token = UUID.randomUUID().toString();
    }
}
