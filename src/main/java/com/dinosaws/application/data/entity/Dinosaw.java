package com.dinosaws.application.data.entity;

import com.example.application.data.AbstractEntity;
import com.vaadin.flow.component.html.Image;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Dinosaw extends AbstractEntity {
    private String name;
//    private List<Image> images;
    private Image latestImage;
    private String description;

    public void addImage(Image image){
//        this.images.add(image);
        this.latestImage = image;
    }

    public Dinosaw(String name, Image latestImage, String description) {
        this.name = name;
        this.latestImage = latestImage;
        this.description = description;
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
