package com.dfs.dfsbitehackmobile.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dfs.dfsbitehackmobile.R;
import com.dfs.dfsbitehackmobile.dto.Kgex;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class MatchActivity extends AppCompatActivity {
    //TODO remove after json communication implemented
    private String mockJSON = "{\"kgex\":{\"nick\":\"FluffyKitty\",\"email\":\"fluffykitty@cats.com\",\"skills\":[\"Purr\",\"Meow\",\"Skratch\",\"Bite\",\"Becute\",\"Benice\",\"Begreat\",\"Beloved\"],\"wanted\":[\"ruletheworld\",\"creatingbirdstokill\",\"creatingtoystoplaywith\"]}}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        //Intent matchIntent = getIntent();
        //String value = matchIntent.getStringExtra("key");

        initializeComponents();
    }

    private void initializeComponents() {
        Button likeButton = findViewById(R.id.likeButton);
        Button dislikeButton = findViewById(R.id.dislikeButton);
        Button backButton = findViewById(R.id.backButton);
        LinearLayout skillsLayout = findViewById(R.id.skillsList);
        LinearLayout wantedLayout = findViewById(R.id.wantedList);

        Kgex currentKgex;
        try {
            currentKgex = parseKgexJSON(mockJSON);
        } catch (UnsupportedEncodingException | JSONException e) {
            throw new RuntimeException(e);
        }

        for (String skill : currentKgex.getSkills()) {
            TextView skillTextView = new TextView(this);
            skillTextView.setText(skill);
            skillTextView.setLayoutParams(skillsLayout.getLayoutParams());
            skillsLayout.addView(skillTextView);
        }
        for (String wanted : currentKgex.getWanted()) {
            TextView wantedTextView = new TextView(this);
            wantedTextView.setText(wanted);
            wantedTextView.setLayoutParams(wantedLayout.getLayoutParams());
            wantedLayout.addView(wantedTextView);
        }

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

    private Kgex parseKgexJSON(String jsonString) throws UnsupportedEncodingException, JSONException {
        JSONObject kgexJson = new JSONObject(jsonString).getJSONObject("kgex");
        JSONArray kgexSkillsJson = kgexJson.getJSONArray("skills");
        JSONArray kgexWantedJson = kgexJson.getJSONArray("wanted");

        Kgex kgex = new Kgex();
        kgex.setNick(kgexJson.getString("nick"));
        kgex.setEmail(kgexJson.getString("email"));
        for (int i = 0; i < kgexSkillsJson.length(); i++) {
            kgex.getSkills().add(kgexSkillsJson.getString(i));
        }
        for (int i = 0; i < kgexWantedJson.length(); i++) {
            kgex.getWanted().add(kgexWantedJson.getString(i));
        }
        return kgex;
    }
}