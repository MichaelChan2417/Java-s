package com.atguigu.qqzone.dao;

import com.atguigu.qqzone.pojo.HostReply;

public interface HostReplyDAO {
    HostReply getHostReplyByTopicId(Integer topicId);

    void delHostReply(Integer replyId);
}
