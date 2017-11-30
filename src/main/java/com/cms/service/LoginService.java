package com.cms.service;

import org.springframework.social.facebook.api.User;

public interface LoginService {
    void handleUserAfterLoginWithFacebook(User userProfile);
}
