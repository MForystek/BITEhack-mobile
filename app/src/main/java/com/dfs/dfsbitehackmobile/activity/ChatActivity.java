package com.dfs.dfsbitehackmobile.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.dfs.dfsbitehackmobile.R;
import com.dfs.dfsbitehackmobile.dto.User;

import java.time.Instant;

public class ChatActivity extends AppCompatActivity {

    private EditText editText;
    private MessageAdapter messageAdapter;
    private User currentUser;
    private User otherUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initializeComponents();
    }

    private void initializeComponents() {
        editText = (EditText) findViewById(R.id.editText);
        currentUser = MockService.getInstance().getCurrentUser();
        otherUser = MockService.getInstance().getUserByNick(getIntent().getStringExtra("nick"));
        messageAdapter = new MessageAdapter(this, MockService.getInstance().getMessages(currentUser, otherUser));
        ListView messagesView = (ListView) findViewById(R.id.messages_view);
        messagesView.setAdapter(messageAdapter);
    }

    public void sendMessage(View view) {
        Message message = new Message(editText.getText().toString(), currentUser, otherUser, Instant.now(), true);
        if (message.getText().length() > 0) {
            MockService.getInstance().writeMessage(message);
            messageAdapter.add(message);
            editText.getText().clear();
        }
    }
}
