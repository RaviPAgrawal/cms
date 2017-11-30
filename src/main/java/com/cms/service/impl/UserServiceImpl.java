package com.cms.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Service;

import com.cms.Roles;
import com.cms.beans.UserDTO;
import com.cms.dao.RoleRepository;
import com.cms.dao.UserRepository;
import com.cms.model.Role;
import com.cms.model.User;
import com.cms.service.UserService;
import com.cms.utils.CmsUtility;

/**
 * Created by raviagrawal on 23/03/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole(Roles.ROLE_USER);
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public UserDTO findById(Long userId) {
        User user = userRepository.findOne(userId);
        UserDTO userDTO = UserDTO.getDtoFromUser(user);
        return userDTO;
    }

    @Override
    public Map<String, Object> update(UserDTO userDTO) {
        User user = userRepository.findOne(userDTO.getId());
        UserDTO.updateUserFromDto(user, userDTO);
        userRepository.save(user);
        return CmsUtility.getSuccessResultMap();
    }

    @Override
    public Map<String, Object> delete(Long userId) {
        userRepository.delete(userId);
        return CmsUtility.getSuccessResultMap();
    }

    @Override
    public void saveUser(org.springframework.social.facebook.api.User userProfile) {
        User user = new User();
        user.setFirstName(userProfile.getFirstName());
        user.setLastName(userProfile.getLastName());
        user.setEmail(userProfile.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode("12341234"));
        user.setActive(1);
        Role userRole = roleRepository.findByRole(Roles.ROLE_USER);
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
}
