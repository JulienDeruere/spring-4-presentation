package com.presentation.controllers;

import com.presentation.model.User;
import com.presentation.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.security.Principal;
import java.util.List;

/**
 * @author jderuere
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Inject
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public void add(User user, Principal principal) {
        userService.add(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void get(@PathVariable long id) {
        userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> get() {
        return userService.getUsers();
    }
}