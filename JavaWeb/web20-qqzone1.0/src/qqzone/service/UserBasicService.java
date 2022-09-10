package qqzone.service;

import qqzone.dao.UserBasicDAO;
import qqzone.pojo.UserBasic;

import java.util.List;

public interface UserBasicService {
    // login get
    UserBasic login(String loginId, String pwd);
    // get user's friend list
    List<UserBasic> getFriendList(UserBasic userBasic);
}
