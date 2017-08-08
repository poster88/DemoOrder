package com.example.user.demoorder;

/**
 * Created by User on 008 08.08.17.
 */

public class TitleModel {
    private String title;
    private String description;

    public TitleModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public TitleModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
