package com.michael.mybatis.test;

import com.michael.mybatis.mapper.SpecialSQLMapper;
import com.michael.mybatis.pojo.User;
import com.michael.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SpecialSQLTest {

    @Test
    public void testBlurSearch(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);

        List<User> users = mapper.getBlurUser("m");
        System.out.println(users);

        sqlSession.close();
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);

        mapper.deleteBatch("9,10");

        sqlSession.close();
    }

    @Test
    public void testgetUserList(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);

        List<User> users = mapper.getUserList("t_user");
        System.out.println(users);

        sqlSession.close();
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);

        User user = new User(null, "Jack", "abc123", 18, "male", "Jack@gmail.com");
        mapper.insertUser(user);
        System.out.println(user);

        sqlSession.close();
    }
}
