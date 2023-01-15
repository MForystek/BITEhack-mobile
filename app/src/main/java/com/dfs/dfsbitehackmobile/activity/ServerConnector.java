package com.dfs.dfsbitehackmobile.activity;

import java.io.IOException;

import okhttp3.*;

public class ServerConnector {
    private static ServerConnector INSTANCE;

    public synchronized static ServerConnector getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ServerConnector();
        }
        return INSTANCE;
    }


    private ServerConnector() {}

    public void signup() {
        System.out.println("signup intro");
        String json = "{\n" +
                "    \"username\": \"kgex1\",\n" +
                "    \"email\": \"kgex1@gmail.com\",\n" +
                "    \"password\": \"kgex1\",\n" +
                "    \"role\": [\"user\"]\n" +
                "}";

        String base_url = "http://10.42.0.1:8091";

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), json);

        Request request = new Request.Builder()
                .url(base_url + "/api/auth/signup")
                .post(body)
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        try (Response response = call.execute()) {
            int code = response.code();

            System.out.println(response.body());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public class AccessToken {
        protected String token;

//        public SimpleEntity(String name) {
//            this.name = name;
//        }

        // no-arg constructor, getters, and setters
    }
}
