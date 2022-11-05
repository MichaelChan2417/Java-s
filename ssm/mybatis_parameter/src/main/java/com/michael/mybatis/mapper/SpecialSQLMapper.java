package com.michael.mybatis.mapper;

import com.michael.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSQLMapper {

    /**
     * User part of the user's name to find the user
     * @param containedChar
     * @return
     */
    List<User> getBlurUser(@Param("blur") String containedChar);

    /**
     * Delete users with id in batches
     * @param ids
     */
    void deleteBatch(@Param("ids") String ids);

    /**
     * Dynamically set the table name, find user's info
     * @param tableName
     * @return
     */
    List<User> getUserList(@Param("tableName") String tableName);

    /**
     * Insert user and set its id
     * @param user
     */
    void insertUser(User user);
}
