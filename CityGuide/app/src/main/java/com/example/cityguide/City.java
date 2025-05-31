package com.example.cityguide;

public class City {
    public String name;
    public String imageName;

    public City(String name, String imageName) {
        this.name = name;
        this.imageName = imageName;
    }

    public String getName() {
        return name;
    }

    public String getImageName() {
        return imageName;
    }
}
