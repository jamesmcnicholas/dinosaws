package com.dinosaws.model;

import com.vaadin.flow.component.html.Image;

import java.util.ArrayList;
import java.util.List;

public class Dinosaw {
    private String name;
    private List<Image> images;
    private Image latestImage;
    private String description;

    public Dinosaw(String name, String description) {
        this.name = name;
        this.description = description;
        images = new ArrayList<>();
    }

    public Dinosaw(String name, String description, Image latestImage) {
        this.name = name;
        this.latestImage = latestImage;
        this.description = description;

        images = new ArrayList<>();
        images.add(latestImage);
    }

    public void addImage(Image image){
        this.images.add(image);
        this.latestImage = image;
    }

    public String getName() {
        return name;
    }

    public Image getLatestImage() {
        return latestImage;
    }

    public String getDescription() {
        return description;
    }
}
