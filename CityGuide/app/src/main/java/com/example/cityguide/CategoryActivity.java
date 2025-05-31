package com.example.cityguide;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class CategoryActivity extends BaseActivity {

    private String currentCity; // сюда сохраним город

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupLayout(R.layout.activity_category);

        // Получаем город
        currentCity = getIntent().getStringExtra("city");

        // Показываем город в заголовке
        TextView cityLabel = findViewById(R.id.current_city);
        if (currentCity != null) {
            cityLabel.setText(currentCity);
        } else {
            cityLabel.setText("Город не выбран");
        }

        // Кнопки категорий
        Button buttonParks = findViewById(R.id.button_parks);
        Button buttonMonuments = findViewById(R.id.button_monuments);
        Button buttonActive = findViewById(R.id.button_active);
        Button buttonFeelings = findViewById(R.id.button_feelings);
        Button buttonNature = findViewById(R.id.button_nature);
        Button buttonExhibitions = findViewById(R.id.button_exhibitions);
        Button buttonGames = findViewById(R.id.button_games);
        Button buttonArt = findViewById(R.id.button_art);

        // Устанавливаем обработчики
        buttonParks.setOnClickListener(v -> openPlaceList("парк"));
        buttonMonuments.setOnClickListener(v -> openPlaceList("культура"));
        buttonActive.setOnClickListener(v -> openPlaceList("активный отдых"));
        buttonFeelings.setOnClickListener(v -> openPlaceList("новые ощущения"));
        buttonNature.setOnClickListener(v -> openPlaceList("флора и фауна"));
        buttonExhibitions.setOnClickListener(v -> openPlaceList("выставки"));
        buttonGames.setOnClickListener(v -> openPlaceList("игры"));
        buttonArt.setOnClickListener(v -> openPlaceList("искусство"));
    }

    // Метод перехода на экран списка мест
    private void openPlaceList(String category) {
        Intent intent = new Intent(this, PlaceListActivity.class);
        intent.putExtra("category", category);
        intent.putExtra("city", currentCity); // передаём город сюда!
        startActivity(intent);
    }
}
