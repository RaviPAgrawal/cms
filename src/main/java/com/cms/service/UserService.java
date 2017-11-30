package com.cms.service;

import java.util.Map;

import org.springframework.social.connect.UserProfile;

import com.cms.beans.UserDTO;
import com.cms.model.User;

/**
 * Created by raviagrawal on 15/03/17.
 */
public interface UserService {

    User findUserByEmail(String email);

    void saveUser(User user);

    UserDTO findById(Long userId);

    Map<String, Object> update(UserDTO userDTO);

    Map<String, Object> delete(Long userId);

    void saveUser(org.springframework.social.facebook.api.User userProfile);

}
