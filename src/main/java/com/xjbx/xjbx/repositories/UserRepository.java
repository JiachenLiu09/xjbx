package com.xjbx.xjbx.repositories;

import com.xjbx.xjbx.enitites.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserByUserName(String userName);
    List<User> findAllByGender(String gender);
    User findUserByUserNameAndUserPassword(String userName, String userPassword);
    void deleteUserByUserName(String userName);
    boolean existsUserByUserName(String userName);

}
