package com.example.cityguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setupLayout(int layoutResID) {
        super.setContentView(R.layout.activity_base_container); // это контейнер с FrameLayout и нижней панелью

        FrameLayout contentFrame = findViewById(R.id.content_frame);
        LayoutInflater.from(this).inflate(layoutResID, contentFrame, true);

        Button cityButton = findViewById(R.id.city_button);
        Button favButton = findViewById(R.id.favorites_button);

        cityButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        favButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, FavoriteActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }
}
