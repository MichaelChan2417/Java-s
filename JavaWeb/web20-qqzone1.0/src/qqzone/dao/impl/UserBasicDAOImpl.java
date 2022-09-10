package qqzone.dao.impl;

import qqzone.dao.UserBasicDAO;
import myssm.basedao.BaseDAO;
import qqzone.pojo.UserBasic;

import java.util.List;

public class UserBasicDAOImpl extends BaseDAO<UserBasic> implements UserBasicDAO {
    @Override
    public UserBasic getUserBasic(String loginId, String pwd) {
        String sql = "select * from t_user_basic where loginId = ? and pwd = ?";
        return super.load(sql, loginId, pwd);
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        String sql = "select * from t_user_basic where id = ?";
        return super.load(sql, id);
    }

    @Override
    public List<UserBasic> getFriendList(UserBasic userBasic) {
        String sql = "select fid as id from t_friend where uid = ?";
        return super.executeQuery(sql, userBasic.getId());
    }
}
