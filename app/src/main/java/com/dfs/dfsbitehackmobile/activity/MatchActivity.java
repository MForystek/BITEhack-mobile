package com.dfs.dfsbitehackmobile.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dfs.dfsbitehackmobile.R;
import com.dfs.dfsbitehackmobile.dto.User;
import com.dfs.dfsbitehackmobile.util.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        initializeComponents();
    }

    private void initializeComponents() {
        Button likeButton = findViewById(R.id.likeButton);
        Button dislikeButton = findViewById(R.id.dislikeButton);

        loadNextUser();

        likeButton.setOnClickListener(view -> {
            Toast.makeText(this, "Of course you like him!", Toast.LENGTH_SHORT).show();
            loadNextUser();
        });

        dislikeButton.setOnClickListener(view -> {
            Toast.makeText(this, "Why you don't like him?", Toast.LENGTH_SHORT).show();
            loadNextUser();
        });
    }

    private void loadNextUser() {
        LinearLayout ownedSkillsLinearLayout = findViewById(R.id.ownedSkillsList);
        LinearLayout wantedSkillsLinearLayout = findViewById(R.id.wantedSkillsList);

        ownedSkillsLinearLayout.removeAllViews();
        wantedSkillsLinearLayout.removeAllViews();

        User currentUser = MockService.getInstance().getNextUser();

        int pxMargin = Utils.convertDpToPx(5, this);

        addUserOwnedSkillsToOwnedSkillsScrollView(ownedSkillsLinearLayout, currentUser, pxMargin);
        addUserWantedSkillsToWantedSkillsScrollView(wantedSkillsLinearLayout, currentUser, pxMargin);

        TextView nickTextView = findViewById(R.id.user_name);
        nickTextView.setText(currentUser.getNick());
    }

    private void addUserOwnedSkillsToOwnedSkillsScrollView(LinearLayout ownedSkillsLayout, User currentUser, int pxMargin) {
        TextView ownedSkillsTextView = new TextView(this);
        ownedSkillsTextView.setText(getString(R.string.user_wanted_skills));
        LinearLayout.LayoutParams ownedSkillsLayoutParams = new LinearLayout.LayoutParams(ownedSkillsLayout.getLayoutParams());
        ownedSkillsLayoutParams.setMargins(pxMargin, pxMargin*2, pxMargin, pxMargin);
        ownedSkillsTextView.setLayoutParams(ownedSkillsLayoutParams);
        ownedSkillsLayout.addView(ownedSkillsTextView);

        for (String ownedSkill : currentUser.getOwnedSkills()) {
            TextView ownedSkillTextView = new TextView(this);
            ownedSkillTextView.setText(ownedSkill);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ownedSkillsLayout.getLayoutParams());
            layoutParams.setMargins(pxMargin*4, 0, pxMargin, pxMargin*2);
            ownedSkillTextView.setLayoutParams(layoutParams);
            ownedSkillsLayout.addView(ownedSkillTextView);
        }
    }

    private void addUserWantedSkillsToWantedSkillsScrollView(LinearLayout wantedSkillsLayout, User currentUser, int pxMargin) {
        TextView wantedSkillsTextView = new TextView(this);
        wantedSkillsTextView.setText(getString(R.string.user_owned_skills));
        LinearLayout.LayoutParams wantedSkillsLayoutParams = new LinearLayout.LayoutParams(wantedSkillsLayout.getLayoutParams());
        wantedSkillsLayoutParams.setMargins(pxMargin, pxMargin*2, pxMargin, pxMargin);
        wantedSkillsTextView.setLayoutParams(wantedSkillsLayoutParams);
        wantedSkillsLayout.addView(wantedSkillsTextView);

        for (String wantedSkill : currentUser.getWantedSkills()) {
            TextView wantedSkillTextView = new TextView(this);
            wantedSkillTextView.setText(wantedSkill);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(wantedSkillsLayout.getLayoutParams());
            layoutParams.setMargins(pxMargin*4, 0, pxMargin, pxMargin*2);
            wantedSkillTextView.setLayoutParams(layoutParams);
            wantedSkillsLayout.addView(wantedSkillTextView);
        }
    }

    private User parseUserJSON(String jsonString) throws JSONException {
        JSONObject userJson = new JSONObject(jsonString).getJSONObject("user");
        JSONArray userOwnedSkillsJson = userJson.getJSONArray("owned_skills");
        JSONArray userWantedSkillsJson = userJson.getJSONArray("wanted_skills");

        User user = new User();
        user.setNick(userJson.getString("nick"));
        user.setEmail(userJson.getString("email"));
        for (int i = 0; i < userOwnedSkillsJson.length(); i++) {
            user.getOwnedSkills().add(userOwnedSkillsJson.getString(i));
        }
        for (int i = 0; i < userWantedSkillsJson.length(); i++) {
            user.getWantedSkills().add(userWantedSkillsJson.getString(i));
        }
        return user;
    }
}