package com.thinkdev.healix.model;

public class NotificationChildModel {

    private String title, description, time;
    private int icon;

    public NotificationChildModel(String title, String description, String time, int icon) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.icon = icon;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
