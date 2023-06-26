package com.thinkdev.healix.model;

public class TransactionChildModel {
    private int icon, percentage;
    private String title, description, time;

    public TransactionChildModel(int icon, int percentage, String title, String description, String time) {
        this.icon = icon;
        this.percentage = percentage;
        this.title = title;
        this.description = description;
        this.time = time;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
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
}
