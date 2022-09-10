package com.atguigu.qqzone.dao.impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.atguigu.qqzone.dao.HostReplyDAO;
import com.atguigu.qqzone.pojo.HostReply;

public class HostReplyDAOImpl extends BaseDAO<HostReply> implements HostReplyDAO {
    @Override
    public HostReply getHostReplyByTopicId(Integer topicId) {
        return load("select * from t_host_reply where reply = ?", topicId);
    }

    @Override
    public void delHostReply(Integer replyId) {
        super.executeUpdate("delete from t_host_reply where id = ?", replyId);
    }
}
