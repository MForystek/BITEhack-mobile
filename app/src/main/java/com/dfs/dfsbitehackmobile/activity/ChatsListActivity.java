package com.dfs.dfsbitehackmobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dfs.dfsbitehackmobile.R;
import com.dfs.dfsbitehackmobile.dto.User;
import com.dfs.dfsbitehackmobile.util.Utils;

import java.util.List;

public class ChatsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats_list);

        initializeComponents();
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void initializeComponents() {
        LinearLayout chatListLinearLayout = findViewById(R.id.chatsListLinearLayout);

        List<User> userChats = MockService.getInstance().getUserChats();

        for (int i = 0; i < userChats.size(); i++) {
            String nick = userChats.get(i).getNick();
            Button chatButton = new Button(this);
            String lastMessage = "Your last message from this chat";
            chatButton.setText(getResources().getString(R.string.chat_display, nick, lastMessage));
            chatButton.setOnClickListener(view -> {
                Intent chatIntent = new Intent(ChatsListActivity.this, ChatActivity.class);
                chatIntent.putExtra("nick", nick);
                ChatsListActivity.this.startActivity(chatIntent);
            });

            int px = Utils.convertDpToPx(20, this);

            LinearLayout.LayoutParams chatButtonLayoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            chatButtonLayoutParams.setMargins(0, 0, 0, px / 2);
            chatButton.setLayoutParams(chatButtonLayoutParams);
            chatButton.setBackground(getResources().getDrawable(R.drawable.my_message));
            chatButton.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
            chatButton.setPadding(px, px, px, px);
            chatListLinearLayout.addView(chatButton);
        }
    }
}