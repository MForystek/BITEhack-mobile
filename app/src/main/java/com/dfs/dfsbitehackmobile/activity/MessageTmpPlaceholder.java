package com.dfs.dfsbitehackmobile.activity;

import java.util.ArrayList;
import java.util.List;

public class MessageTmpPlaceholder {

    private final List<String> messageList = new ArrayList<>();

    public void addMessage(String message) {
        messageList.add(message);
    }

    public List<String> getMessages() {
        return messageList;
    }
}
