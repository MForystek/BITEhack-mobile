package com.dfs.dfsbitehackmobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.dfs.dfsbitehackmobile.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initializeComponents();
    }

    private void initializeComponents() {
        Button startButton = findViewById(R.id.startButton);
        Button singleChatButton = findViewById(R.id.singleChatButton);
        Button chatsListButton = findViewById(R.id.chatsListButton);
        Button exitButton = findViewById(R.id.exitButton);

        startButton.setOnClickListener(view -> {
            Intent matchIntent = new Intent(WelcomeActivity.this, MatchActivity.class);
            WelcomeActivity.this.startActivity(matchIntent);
        });

        singleChatButton.setOnClickListener(view -> {
            Intent chatIntent = new Intent(WelcomeActivity.this, ChatActivity.class);
            chatIntent.putExtra("nick", ""); //todo: when this is moved to separate class, pass nick of person that user is chatting with.
            WelcomeActivity.this.startActivity(chatIntent);
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