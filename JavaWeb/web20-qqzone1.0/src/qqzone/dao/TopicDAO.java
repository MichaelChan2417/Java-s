package qqzone.dao;

import qqzone.pojo.Topic;
import qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicDAO {
    // get all topics from specific person
    public List<Topic> getTopicList(UserBasic userBasic);

    // add topic
    public void addTopic(Topic topic);

    // del topic
    public void delTopic(Topic topic);

    // get detailed info on topic
    public Topic getTopic(Integer id);

}
