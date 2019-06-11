package com.xjbx.xjbx.services;

import com.xjbx.xjbx.enitites.User;
import com.xjbx.xjbx.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUserByName(String userName) {
        userRepository.deleteUserByUserName(userName);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public User findUserByName(String userName) {
        if(userRepository.existsUserByUserName(userName))
            return userRepository.findUserByUserName(userName);
        return null;
    }

    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public List<User> findAllUsersByUserGender(String userGender) {
        return userRepository.findAllByUserGender(userGender);
    }

    public User userLogin(String userName, String userPassword) {
        return userRepository.findUserByUserNameAndUserPassword(userName, userPassword);
    }

}
