package com.michael.mybatis.mapper;

import com.michael.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    /**
     * Get user's info based on id
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);

    /**
     * Get all the users
     * @return
     */
    List<User> getAllUser();

    /**
     * get total user numbers
     * @return
     */
    Integer getCount();


    /**
     * get user by id and put it into a map
     * @return
     */
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);


    // List<Map<String, Object>>
    @MapKey("id") // 查询的字段作为key
    Map<String, Object> getAllUserToMap();
}
