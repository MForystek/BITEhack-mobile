package com.dfs.dfsbitehackmobile.activity;

import com.dfs.dfsbitehackmobile.dto.User;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockService implements ServiceAPI {
    private static MockService mockServiceInstance = null;
    private final List<User> users;
    private final List<Message> messages;
    private int counter = 0;
    private MockService() {
        //normally connection here
        users = new ArrayList<>();
        users.add(new User("Adam", "adampączkizjadam2137@poczta.com", "green", Arrays.asList("purring", "sleeping"), Arrays.asList("killing", "meowing")));
        users.add(new User("Mathew", "maciekpaciek@poczta.com", "red", Arrays.asList("guitar playing", "chess"), Arrays.asList("scuba diving", "driving")));
        messages = new ArrayList<>();
        messages.add(
                new Message("cześć", users.get(1), users.get(0), Instant.parse("2023-01-14T18:38:24.00Z"),  false));
        messages.add(
                new Message("hej", users.get(0), users.get(1), Instant.parse("2023-01-14T18:35:24.00Z"), true));
    }

    public static MockService getInstance() {
        if (mockServiceInstance == null) {
            mockServiceInstance = new MockService();
        }
        return mockServiceInstance;
    }

    @Override
    public User getCurrentUser() {
        return users.get(0);
    }

    @Override
    public User getNextUser() {
        User nextUser = users.get(counter);
        counter = counter >= users.size() - 1 ? 0 : ++counter;
        return nextUser;
    }

    @Override
    public User getUserByNick(String nick) {
        return users.get(1);
    }

    @Override
    public List<Message> getMessages(User user1, User user2) {
        return messages;
    }

    @Override
    public void writeMessage(Message message) {
        messages.add(message);
    }
}
