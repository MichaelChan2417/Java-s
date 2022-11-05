package com.michael.mybatis.test;

import com.michael.mybatis.mapper.SelectMapper;
import com.michael.mybatis.pojo.User;
import com.michael.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);

        User user = mapper.getUserById(2);
        System.out.println(user);

        sqlSession.close();
    }


    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);

        List<User> user = mapper.getAllUser();
        user.forEach(System.out::println);

        sqlSession.close();
    }


    @Test
    public void testTotalCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);

        int manCount = mapper.getCount();
        System.out.println(manCount);

        sqlSession.close();
    }


    @Test
    public void testUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);

        Map<String, Object> userByIdToMap = mapper.getUserByIdToMap(4);
        System.out.println(userByIdToMap);

        sqlSession.close();
    }


    @Test
    public void testgetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);

        Map<String, Object> allUserToMap = mapper.getAllUserToMap();
        System.out.println(allUserToMap);

        sqlSession.close();
    }
}
