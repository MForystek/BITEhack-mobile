package com.dfs.dfsbitehackmobile.dto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String nick;

    //todo: make this an actual image
    private String image;
    private String email;
    private final List<String> ownedSkills;
    private final List<String> wantedSkills;

    public User() {
        nick = "N/A";
        email = "na@na.na";
        image = "blue";
        ownedSkills = new ArrayList<>();
        wantedSkills = new ArrayList<>();
    }

    public User(String nick, String email, String image, List<String> ownedSkills, List<String> wantedSkills) {
        this.nick = nick;
        this.email = email;
        this.image = image;
        this.ownedSkills = ownedSkills;
        this.wantedSkills = wantedSkills;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getOwnedSkills() {
        return ownedSkills;
    }

    public List<String> getWantedSkills() {
        return wantedSkills;
    }
}
