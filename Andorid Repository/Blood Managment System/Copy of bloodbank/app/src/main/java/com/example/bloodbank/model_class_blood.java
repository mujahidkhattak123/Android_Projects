package com.example.bloodbank;

/**
 * Created by Belal on 9/5/2017.
 */

public class model_class_blood {
    String name, imageUrl;

    public model_class_blood(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
