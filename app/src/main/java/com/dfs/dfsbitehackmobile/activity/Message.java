package com.dfs.dfsbitehackmobile.activity;

public class Message {
    private final String text;
    private final KGexUserData KGexUserData;
    private final boolean belongsToCurrentUser;

    public Message(String text, KGexUserData data, boolean belongsToCurrentUser) {
        this.text = text;
        this.KGexUserData = data;
        this.belongsToCurrentUser = belongsToCurrentUser;
    }

    public String getText() {
        return text;
    }

    public KGexUserData getKGexUserData() {
        return KGexUserData;
    }

    public boolean isBelongsToCurrentUser() {
        return belongsToCurrentUser;
    }
}
