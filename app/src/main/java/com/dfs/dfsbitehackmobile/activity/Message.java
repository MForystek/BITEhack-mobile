package com.dfs.dfsbitehackmobile.activity;

import com.dfs.dfsbitehackmobile.dto.User;

public class Message {
    private final String text;
    private final User User;
    private final boolean belongsToCurrentUser;

    public Message(String text, User user, boolean belongsToCurrentUser) {
        this.text = text;
        this.User = user;
        this.belongsToCurrentUser = belongsToCurrentUser;
    }

    public String getText() {
        return text;
    }

    public User getUser() {
        return User;
    }

    public boolean isBelongsToCurrentUser() {
        return belongsToCurrentUser;
    }
}
