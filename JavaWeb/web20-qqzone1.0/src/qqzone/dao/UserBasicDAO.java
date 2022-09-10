package qqzone.dao;

import qqzone.pojo.UserBasic;
import qqzone.service.UserBasicService;

import java.util.List;

public interface UserBasicDAO {
    // get user's info based on account and pwd
    public UserBasic getUserBasic(String loginId, String pwd);

    public UserBasic getUserBasicById(Integer id);

    // get friend list
    public List<UserBasic> getFriendList(UserBasic userBasic);

}
