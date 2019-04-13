package com.dreamfactory.novax.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.dreamfactory.novax.R;

public class SocialFollowes extends AppCompatActivity {

    private Toolbar toolBarSoicalFollowers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_followes);

        toolBarSoicalFollowers = findViewById(R.id.toolBarSoicalFollowers);
        toolBarSoicalFollowers.setTitle("Social Followers");
        setSupportActionBar(toolBarSoicalFollowers);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }
}
