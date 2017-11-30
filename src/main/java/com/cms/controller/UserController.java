package com.cms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cms.beans.UserDTO;
import com.cms.service.UserService;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;

/**
 * Created by raviagrawal on 15/03/17.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public UserDTO getUser(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> updateUser(@RequestBody UserDTO userDTO) {
        return userService.update(userDTO);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteUser(@PathVariable Long userId) {
        return userService.delete(userId);
    }
}
