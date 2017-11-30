package com.cms.beans;

import lombok.Getter;
import lombok.Setter;

import com.cms.model.User;

/**
 * Created by raviagrawal on 06/04/17.
 */
@Getter @Setter
public class UserDTO {
    private Long id;
    private String name;
    private TeamDTO teamDTO;

    public static User getUserFromDto(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getName());
        return user;
    }

    public static UserDTO getDtoFromUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getFirstName());
        return userDTO;
    }

    public static void updateUserFromDto(User user, UserDTO userDTO) {
        user.setFirstName(userDTO.getName());
    }
}
