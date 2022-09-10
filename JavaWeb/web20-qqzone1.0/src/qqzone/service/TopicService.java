package qqzone.service;

import qqzone.pojo.Topic;
import qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicService {
    // get topic list
    List<Topic> getTopicList(UserBasic userBasic);
}
