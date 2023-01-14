package com.dfs.dfsbitehackmobile.activity;

import com.dfs.dfsbitehackmobile.dto.User;

import java.util.Arrays;

public class MockService implements ServiceAPI {

    private static MockService mockServiceInstance = null;
    private final User currentUser = new User("Adam", "adampączkizjadam2137@poczta.com", "green", Arrays.asList("purring", "sleeping"), Arrays.asList("killing", "meowing"));

    private MockService() {
        //normally connection here
    }

    public static MockService getInstance() {
        if (mockServiceInstance == null) {
            mockServiceInstance = new MockService();
        }
        return mockServiceInstance;
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public User getUser(String nick) {
        return new User("Mathew", "maciekpaciek@poczta.com", "red", Arrays.asList("guitar playing", "chess"), Arrays.asList("scuba diving", "driving"));
    }
}
