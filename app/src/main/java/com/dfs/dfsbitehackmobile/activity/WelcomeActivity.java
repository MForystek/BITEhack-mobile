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
        Button exitButton = findViewById(R.id.exitButton);

        startButton.setOnClickListener(view -> {
            Intent matchIntent = new Intent(WelcomeActivity.this, MatchActivity.class);
            //matchIntent.putExtra("key", value);
            WelcomeActivity.this.startActivity(matchIntent);
        });

        exitButton.setOnClickListener(view -> {
            setResult(RESULT_OK);
            android.os.Process.killProcess(android.os.Process.myPid());
            finish();
        });
    }
}