package com.example.cityguide;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PlaceListActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupLayout(R.layout.activity_place_list); // подключает макет и нижнюю панель

        ListView listView = findViewById(R.id.place_list);
        DBHelper dbHelper = new DBHelper(this);

        // Получаем категорию и город
        String category = getIntent().getStringExtra("category");
        String city = getIntent().getStringExtra("city");

        // Загружаем места по категории и городу
        ArrayList<Place> places = dbHelper.getPlacesByCategory(category, city);

        PlaceAdapter adapter = new PlaceAdapter(this, places);
        listView.setAdapter(adapter);
    }
}
