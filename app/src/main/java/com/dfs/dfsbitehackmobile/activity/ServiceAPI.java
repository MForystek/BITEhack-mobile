package com.dfs.dfsbitehackmobile.activity;

import com.dfs.dfsbitehackmobile.dto.User;

public interface ServiceAPI {
    User getCurrentUser();
    User getUser(String nick);
}
