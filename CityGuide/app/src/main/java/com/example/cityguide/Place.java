package com.example.cityguide;

public class Place {
    public String name;
    public String category;
    public String description;
    public String imageName;

    public boolean isFavorite;


    public Place(String name, String category, String description, String imageName, boolean isFavorite) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.imageName = imageName;
        this.isFavorite = isFavorite; // по умолчанию
    }




    @Override
    public String toString() {
        return name + " (Избранное: " + isFavorite + ")"; // чтобы в списке показывалось только имя места
    }


}
