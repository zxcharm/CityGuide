package com.example.cityguide;

import android.widget.ImageView; // импорт вверху
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PlaceDetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        TextView title = findViewById(R.id.place_title);
        TextView description = findViewById(R.id.place_description);

        String name = getIntent().getStringExtra("name");
        String desc = getIntent().getStringExtra("description");

        title.setText(name);
        description.setText(desc);

        ImageView image = findViewById(R.id.place_image);

        name = getIntent().getStringExtra("name"); // просто присвоение

        desc = getIntent().getStringExtra("description");
        String imageName = getIntent().getStringExtra("image");

        if (imageName != null) {
            int resId = getResources().getIdentifier(imageName, "drawable", getPackageName());
            if (resId != 0) {
                image.setImageResource(resId);
            }
        }

        title.setText(name);
        description.setText(desc);

// загрузка картинки по имени
        int resId = getResources().getIdentifier(imageName, "drawable", getPackageName());
        image.setImageResource(resId);


    }
}
