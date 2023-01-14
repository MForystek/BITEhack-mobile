package com.dfs.dfsbitehackmobile.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dfs.dfsbitehackmobile.R;
import com.dfs.dfsbitehackmobile.dto.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.UnsupportedEncodingException;

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
        Button backButton = findViewById(R.id.backButton);
        LinearLayout skillsLinearLayout = findViewById(R.id.skillsList);
        LinearLayout wantedLinearLayout = findViewById(R.id.wantedList);

        User currentUser = MockService.getInstance().getCurrentUser();

        int pxMargin = convertDpToPx(5);

        addKgexSkillsToSkillsScrollView(skillsLinearLayout, currentUser, pxMargin);
        addUserWantedToWantedScrollView(wantedLinearLayout, currentUser, pxMargin);

        TextView nickTextView = findViewById(R.id.kgex_name);
        nickTextView.setText(currentUser.getNick());

        likeButton.setOnClickListener(view -> {
            Toast.makeText(this, "Of course you like him!", Toast.LENGTH_SHORT).show();
        });

        dislikeButton.setOnClickListener(view -> {
            Toast.makeText(this, "Why you don't like him?", Toast.LENGTH_SHORT).show();
        });

        backButton.setOnClickListener(view -> {
            Intent intent = new Intent();
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }


    private void addUserWantedToWantedScrollView(LinearLayout wantedLayout, User currentUser, int pxMargin) {
        for (String wanted : currentUser.getWantedSkills()) {
            TextView wantedTextView = new TextView(this);
            wantedTextView.setText(wanted);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(wantedLayout.getLayoutParams());
            layoutParams.setMargins(pxMargin, pxMargin, pxMargin, pxMargin);
            wantedTextView.setLayoutParams(layoutParams);
            wantedLayout.addView(wantedTextView);
        }
    }

    private void addKgexSkillsToSkillsScrollView(LinearLayout skillsLayout, User currentUser, int pxMargin) {
        for (String skill : currentUser.getOwnedSkills()) {
            TextView skillTextView = new TextView(this);
            skillTextView.setText(skill);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(skillsLayout.getLayoutParams());
            layoutParams.setMargins(pxMargin, pxMargin, pxMargin, pxMargin);
            skillTextView.setLayoutParams(layoutParams);
            skillsLayout.addView(skillTextView);
        }
    }

//    private User parseUserJSON(String jsonString) throws UnsupportedEncodingException, JSONException {
//        JSONObject kgexJson = new JSONObject(jsonString).getJSONObject("kgex");
//        JSONArray kgexSkillsJson = kgexJson.getJSONArray("skills");
//        JSONArray kgexWantedJson = kgexJson.getJSONArray("wanted");
//
//        User user = new User();
//        user.setNick(kgexJson.getString("nick"));
//        user.setEmail(kgexJson.getString("email"));
//        for (int i = 0; i < kgexSkillsJson.length(); i++) {
//            user.getOwnedSkills().add(kgexSkillsJson.getString(i));
//        }
//        for (int i = 0; i < kgexWantedJson.length(); i++) {
//            user.getWantedSkills().add(kgexWantedJson.getString(i));
//        }
//        return user;
//    }

    private int convertDpToPx(int dp) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                this.getResources().getDisplayMetrics()
        );
    }
}