package com.example.cityguide;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;



import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private CityAdapter cityAdapter;
    private List<City> cityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupLayout(R.layout.activity_main);

        // Находим элементы
        EditText searchCity = findViewById(R.id.search_city);
        recyclerView = findViewById(R.id.city_list);

        // Указываем LayoutManager
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this));

// Настраиваем адаптер
        cityAdapter = new CityAdapter(this, cityList);
        recyclerView.setAdapter(cityAdapter);



        // Готовим список городов
        prepareCityList();

        // Настраиваем адаптер
        cityAdapter = new CityAdapter(this, cityList);
        recyclerView.setAdapter(cityAdapter);

        // Поиск
        searchCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString().toLowerCase();
                cityAdapter.filter(query);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void prepareCityList() {
        // Пример — добавим Москву и Питер
        cityList.add(new City("Москва", "moscow_image"));
        cityList.add(new City("Санкт-Петербург", "spb_image"));
        cityList.add(new City("Сыктывкар", "syktyvkar_image"));

        // можно добавить другие города
    }
}
