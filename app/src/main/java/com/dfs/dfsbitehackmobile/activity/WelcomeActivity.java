package com.dfs.dfsbitehackmobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;

import com.dfs.dfsbitehackmobile.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initializeComponents();
        ServerConnector.getINSTANCE().signup();
    }



    private void initializeComponents() {
        Button startButton = findViewById(R.id.startButton);
        Button chatsListButton = findViewById(R.id.chatsListButton);
        Button exitButton = findViewById(R.id.exitButton);

        startButton.setOnClickListener(view -> {
            Intent matchIntent = new Intent(WelcomeActivity.this, MatchActivity.class);
            WelcomeActivity.this.startActivity(matchIntent);
        });

        chatsListButton.setOnClickListener(view -> {
            Intent chatsListIntent = new Intent(WelcomeActivity.this, ChatsListActivity.class);
            WelcomeActivity.this.startActivity(chatsListIntent);
        });

        exitButton.setOnClickListener(view -> {
            setResult(RESULT_OK);
            android.os.Process.killProcess(android.os.Process.myPid());
            finish();
        });
    }
}