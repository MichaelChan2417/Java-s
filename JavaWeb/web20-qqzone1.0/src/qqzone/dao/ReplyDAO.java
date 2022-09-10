package qqzone.dao;

import qqzone.pojo.Reply;
import qqzone.pojo.Topic;

import java.util.List;

public interface ReplyDAO {
    // get all reply list
    public List<Reply> getReply(Topic topic);

    // add reply
    public void addReply(Reply reply);

    // delete reply
    public void delReply(Reply reply);

}
