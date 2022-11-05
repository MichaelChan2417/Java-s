package com.michael.mybatis.mapper;

import com.michael.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * Add User's info
     * @return
     */
    int insertUser();

    /**
     * Update User's info
     */
    void updateUser();

    /**
     * Delete User
     */
    void deleteUser();

    /**
     * Retrieve User
     */
    User getUserById();

    /**
     * Retrieve all users
     * @return List of Users
     */
    List<User> getAllUser();
}
