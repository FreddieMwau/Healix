package com.thinkdev.healix.model;

public class ServicesModel {

    private int icon;
    private String title, description, amount, time;

    public ServicesModel(int icon, String title, String description, String amount, String time) {
        this.icon = icon;
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.time = time;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
