package com.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.service.LoginService;
import com.cms.service.UserService;
import com.cms.utils.AuthenticationUtility;

@Controller
@RequestMapping("/connect")
public class ChangeDefaultFlowController extends ConnectController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    private Facebook facebook;

    public ChangeDefaultFlowController(Facebook facebook, ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
        super(connectionFactoryLocator, connectionRepository);
        this.facebook = facebook;
    }

    @Override
    protected String connectedView(String providerId) {
        User userProfile = facebook.userOperations().getUserProfile();
        loginService.handleUserAfterLoginWithFacebook(userProfile);
        return "redirect:"+AuthenticationUtility.determineTargetUrl(SecurityContextHolder.getContext().getAuthentication());
    }
}
