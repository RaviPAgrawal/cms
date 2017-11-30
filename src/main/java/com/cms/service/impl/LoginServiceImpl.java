package com.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.service.LoginService;
import com.cms.service.SignInService;
import com.cms.service.UserService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Autowired
    private SignInService signInService;

    @Override
    @Transactional
    public void handleUserAfterLoginWithFacebook(User userProfile) {
        if (userService.findUserByEmail(userProfile.getEmail()) == null) {
            userService.saveUser(userProfile);
        }
        signInService.signInUser(userProfile.getEmail());
    }
}
