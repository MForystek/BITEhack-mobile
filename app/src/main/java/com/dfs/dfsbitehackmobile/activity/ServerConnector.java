package com.dfs.dfsbitehackmobile.activity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import okhttp3.*;

public class ServerConnector {

    private static String proto = "http";
    private static String host = "10.42.0.1";
    private static String port = "8091";

    private static final String SIGNUP_EP = "/api/auth/signup";
    private static final String SIGNIN_EP = "/api/auth/signin";
    private static final String USER_DATA_EP = "/api/user/user-data";


    private ServerConnector() {}

    public static boolean signup(String username, String email, String password) throws JSONException {
        JSONObject jsonO = new JSONObject();
        jsonO.put("username", username);
        jsonO.put("email", email);
        jsonO.put("password", password);

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), jsonO.toString());

        Request request = new Request.Builder()
                .url(formatEndpoint(SIGNUP_EP))
                .post(body)
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        try (Response response = call.execute()) {
            return response.isSuccessful();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Instead of simple token return some session object
    public static String signin(String username, String password) throws JSONException {
        JSONObject jsonO = new JSONObject();
        jsonO.put("username", username);
        jsonO.put("password", password);

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), jsonO.toString());

        Request request = new Request.Builder()
                .url(formatEndpoint(SIGNIN_EP))
                .post(body)
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        try (Response response = call.execute()) {
            JSONObject res = new JSONObject(Objects.requireNonNull(response.body()).toString());
            return (String) res.get("token");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static String formatEndpoint(String path) {
        return String.format("%s://%s:%s/%s", proto, host, port, path);
    }
}
