package com.example.cityguide;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FavoriteActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupLayout(R.layout.activity_favorite);


        ListView listView = findViewById(R.id.favorite_list);

        DBHelper dbHelper = new DBHelper(this);
        ArrayList<Place> favoritePlaces = dbHelper.getFavorites();

        PlaceAdapter adapter = new PlaceAdapter(this, favoritePlaces);
        listView.setAdapter(adapter);
    }
}
