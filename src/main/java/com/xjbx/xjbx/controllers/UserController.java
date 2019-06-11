package com.xjbx.xjbx.controllers;

import com.xjbx.xjbx.enitites.User;
import com.xjbx.xjbx.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userName}")
    public void deleteUser(@PathVariable String userName) {
        userService.deleteUserByName(userName);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{userName}")
    public User findUserByName(@PathVariable String userName) {
        return userService.findUserByName(userName);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{gender}")
    public List<User> findAllUsersByGender(@PathVariable String gender) {
        return userService.findAllUsersByGender(gender);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/usersLogin")
    public User userLogin(@RequestBody User user) {
        String userName = user.getUserName();
        String userPassword = user.getUserPassword();
        return userService.userLogin(userName, userPassword);
    }

}
