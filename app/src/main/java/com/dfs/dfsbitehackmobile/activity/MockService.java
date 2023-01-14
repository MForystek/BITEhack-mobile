package com.dfs.dfsbitehackmobile.activity;

import com.dfs.dfsbitehackmobile.dto.User;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class MockService implements ServiceAPI {

    private static MockService mockServiceInstance = null;
    private final User currentUser = new User("Adam", "adampączkizjadam2137@poczta.com", "green", Arrays.asList("purring", "sleeping"), Arrays.asList("killing", "meowing"));
    private final User otherUser = new User("Mathew", "maciekpaciek@poczta.com", "red", Arrays.asList("guitar playing", "chess"), Arrays.asList("scuba diving", "driving"));
    private List<Message> messages = Arrays.asList(
            new Message("hej", currentUser, otherUser, Instant.parse("2023-01-14T18:35:24.00Z"), true),
            new Message("cześć", otherUser, currentUser, Instant.parse("2023-01-14T18:38:24.00Z"),  false)
    );
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
        return otherUser;
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
