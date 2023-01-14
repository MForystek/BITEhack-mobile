package com.dfs.dfsbitehackmobile.activity;

import com.dfs.dfsbitehackmobile.dto.User;

import java.time.Instant;

public class Message implements Comparable<Message> {
    private final String text;
    private final User sender;
    private final User receiver;
    private final Instant timestamp;
    private final boolean belongsToCurrentUser;

    public Message(String text, User sender, User receiver, Instant timestamp, boolean belongsToCurrentUser) {
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp = timestamp;
        this.belongsToCurrentUser = belongsToCurrentUser;
    }

    public String getText() {
        return text;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public boolean isBelongsToCurrentUser() {
        return belongsToCurrentUser;
    }

    @Override
    public int compareTo(Message o) {
        if (this.timestamp == null || o.timestamp == null){
            return 0;
        }
        return this.timestamp.compareTo(o.timestamp);
    }
}
