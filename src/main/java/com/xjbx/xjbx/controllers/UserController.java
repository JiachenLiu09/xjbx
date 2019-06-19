package com.xjbx.xjbx.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xjbx.xjbx.enitites.User;
import com.xjbx.xjbx.services.UserService;
import com.xjbx.xjbx.unit.RestControllerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

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
        return userService.findAllUsersByUserGender(gender);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/usersLogin")
    public Map<String,Object> userLogin(@RequestBody User user) {
        RestControllerHelper helper = new RestControllerHelper();
        String userName = user.getUserName();
        String userPassword = user.getUserPassword();
        User u = userService.userLogin(userName, userPassword);
        if(u != null){
            helper.setCode(RestControllerHelper.SUCCESS);
            helper.setMsg("success");
            helper.setData(u);
            return helper.toJsonMap();
        }
        else if(userService.hasUser(userName)){
            helper.setCode(RestControllerHelper.NOT_FOUND);
            helper.setMsg("Invalid password");
            return helper.toJsonMap();
        }
        else {
            helper.setCode(RestControllerHelper.NOT_FOUND);
            helper.setMsg("Invalid user");
            return helper.toJsonMap();
        }
    }

}
