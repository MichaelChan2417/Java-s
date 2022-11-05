package com.michael.mybatis.mapper;

import com.michael.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /**
     * Find user's info based on username
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * Check with login infos
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username, String password);

    /**
     * Insert/ Create a new user in the database
     * @param user
     */
    void insertUser(User user);

    /**
     * User interpretation to solve parameter choice problem
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
