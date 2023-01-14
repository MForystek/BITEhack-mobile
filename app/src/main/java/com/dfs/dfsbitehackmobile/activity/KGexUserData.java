package com.dfs.dfsbitehackmobile.activity;

import androidx.annotation.NonNull;

class KGexUserData {
    private final String name;
    private final String color;

    public KGexUserData(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @NonNull
    @Override
    public String toString() {
        return "KGexUserData{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}