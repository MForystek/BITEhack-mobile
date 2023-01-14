package com.dfs.dfsbitehackmobile.dto;

import java.util.ArrayList;
import java.util.List;

public class Kger {
    private String nick;
    private String email;
    private final List<String> skills;
    private final List<String> wanted;

    public Kger() {
        nick = "N/A";
        email = "na@na.na";
        skills = new ArrayList<>();
        wanted = new ArrayList<>();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkills() {
        return skills;
    }

    public List<String> getWanted() {
        return wanted;
    }
}
