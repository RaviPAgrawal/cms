package com.cms.utils;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.cms.Roles;

public class AuthenticationUtility {

    public static String determineTargetUrl(final Authentication authentication) {
        boolean isAdmin = Boolean.FALSE;
        boolean isHr = Boolean.FALSE;
        boolean isUser = Boolean.FALSE;

        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (final GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equalsIgnoreCase(Roles.ROLE_ADMIN.name())) {
                isAdmin = Boolean.TRUE;
            }
            if (grantedAuthority.getAuthority().equalsIgnoreCase(Roles.ROLE_HR.name())) {
                isHr = Boolean.TRUE;
            }
            if (grantedAuthority.getAuthority().equalsIgnoreCase(Roles.ROLE_USER.name())) {
                isUser = Boolean.TRUE;
            }
        }
        if (isAdmin) {
            return "/admin/home";
        } else if (isHr) {
            return "/hr/home";
        } else if (isUser) {
            return "/user/home";
        }
        return "/user/home";
    }
}
