package com.dfs.dfsbitehackmobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.dfs.dfsbitehackmobile.R;

import org.json.JSONException;

public class SignUpInActivity extends AppCompatActivity {
    private String email;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);

        Button signUpButton = findViewById(R.id.registrationButton);
        Button signInButton = findViewById(R.id.loginButton);
        Button outerExitButton = findViewById(R.id.outerExitButton);

        signUpButton.setOnClickListener(view -> {
            email = String.valueOf(emailEditText.getText());
            username = String.valueOf(usernameEditText.getText());
            password = String.valueOf(passwordEditText.getText());
            try {
                ServerConnector.signup(username, email, password);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            Intent matchIntent = new Intent(SignUpInActivity.this, WelcomeActivity.class);
            SignUpInActivity.this.startActivity(matchIntent);
        });

        signInButton.setOnClickListener(view -> {
            username = String.valueOf(usernameEditText.getText());
            password = String.valueOf(passwordEditText.getText());
            try {
                ServerConnector.signin(username, password);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            Intent matchIntent = new Intent(SignUpInActivity.this, WelcomeActivity.class);
            SignUpInActivity.this.startActivity(matchIntent);
        });

        outerExitButton.setOnClickListener(view -> {
            setResult(RESULT_OK);
            android.os.Process.killProcess(android.os.Process.myPid());
            finish();
        });

    }
}