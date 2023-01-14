package com.dfs.dfsbitehackmobile.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.dfs.dfsbitehackmobile.R;

public class ChatActivity extends AppCompatActivity {

    private EditText editText;
    private MessageAdapter messageAdapter;

    private MessageTmpPlaceholder messageDatabase;

    // todo: replace with real user
    private final KGexUserData tmpUser = new KGexUserData("Adam", "blue");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        editText = (EditText) findViewById(R.id.editText);

        //todo: add to adapter message history
        messageAdapter = new MessageAdapter(this);
        ListView messagesView = (ListView) findViewById(R.id.messages_view);
        messagesView.setAdapter(messageAdapter);

        messageDatabase = new MessageTmpPlaceholder();
    }

    public void sendMessage(View view) {
        String message = editText.getText().toString();
        if (message.length() > 0) {
            messageDatabase.addMessage(message);
            messageAdapter.add(new Message(message, tmpUser, true));
            editText.getText().clear();
        }
    }
}
