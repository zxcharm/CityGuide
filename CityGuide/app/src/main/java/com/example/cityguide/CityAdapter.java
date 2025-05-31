package com.example.cityguide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

    private Context context;
    private List<City> fullList;  // Полный список
    private List<City> filteredList;  // Фильтрованный список

    public CityAdapter(Context context, List<City> cityList) {
        this.context = context;
        this.fullList = new ArrayList<>(cityList);
        this.filteredList = cityList;
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.city_item, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        City city = filteredList.get(position);
        holder.nameView.setText(city.name);

        int resId = context.getResources().getIdentifier(city.imageName, "drawable", context.getPackageName());
        if (resId != 0) {
            holder.imageView.setImageResource(resId);
        } else {
            holder.imageView.setImageResource(R.drawable.placeholder);
        }

        // При клике — переход в CategoryActivity
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, CategoryActivity.class);
            intent.putExtra("city", city.getName()); // передаём название города!
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    public void filter(String query) {
        filteredList = new ArrayList<>();
        for (City city : fullList) {
            if (city.name.toLowerCase().contains(query)) {
                filteredList.add(city);
            }
        }
        notifyDataSetChanged();
    }

    static class CityViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameView;

        public CityViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.city_image);
            nameView = itemView.findViewById(R.id.city_name);
        }
    }
}
