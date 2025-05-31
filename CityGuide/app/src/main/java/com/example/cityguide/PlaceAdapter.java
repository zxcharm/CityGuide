package com.example.cityguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageButton;
import android.util.Log;

import java.util.List;

public class PlaceAdapter extends ArrayAdapter<Place> {
    public PlaceAdapter(Context context, List<Place> places) {
        super(context, 0, places);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Place place = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.place_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.place_image);
        TextView nameView = convertView.findViewById(R.id.place_name);
        TextView addressView = convertView.findViewById(R.id.place_address);
        TextView descView = convertView.findViewById(R.id.place_description);
        ImageButton favButton = convertView.findViewById(R.id.favorite_button);

        nameView.setText(place.name);

        // разделяем адрес и описание по символу переноса строки
        String[] parts = place.description.split("\n", 2);
        if (parts.length == 2) {
            addressView.setText(parts[0]);       // адрес
            descView.setText(parts[1]);          // остальное описание
        } else {
            addressView.setText("");             // нет адреса
            descView.setText(place.description); // всё описание
        }

        int resId = getContext().getResources().getIdentifier(place.imageName, "drawable", getContext().getPackageName());
        if (resId != 0) {
            imageView.setImageResource(resId);
        }
        Log.d("FAV_DEBUG", place.name + " → isFavorite = " + place.isFavorite);

        // 🔁 Обновляем звезду — ВАЖНО: после обновления текста
        favButton.setImageResource(place.isFavorite ? R.drawable.ic_star_filled : R.drawable.ic_star_border);

        // ⭐ Обработка нажатия
        favButton.setOnClickListener(v -> {
            Log.d("FAV_CLICK", "Звезда нажата: " + place.name);

            place.isFavorite = !place.isFavorite;
            DBHelper dbHelper = new DBHelper(getContext());
            dbHelper.setFavorite(place.name, place.isFavorite);

            favButton.setImageResource(place.isFavorite ? R.drawable.ic_star_filled : R.drawable.ic_star_border);
        });


        return convertView;
    }


}
