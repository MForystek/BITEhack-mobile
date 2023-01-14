package com.dfs.dfsbitehackmobile.activity;

import com.dfs.dfsbitehackmobile.dto.User;

import java.util.List;

public interface ServiceAPI {
    User getCurrentUser();
    User getUser(String nick);
    List<Message> getMessages(User user1, User user2);
    void writeMessage(Message message);
}
