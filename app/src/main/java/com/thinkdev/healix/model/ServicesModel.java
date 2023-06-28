package com.thinkdev.healix.model;

import java.util.List;

public class ServicesModel {
    private String date, day, month, amount;
    private List<ServicesChildModel> childModelList;

    public ServicesModel(String date, String day, String month, String amount, List<ServicesChildModel> childModelList) {
        this.date = date;
        this.day = day;
        this.month = month;
        this.amount = amount;
        this.childModelList = childModelList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<ServicesChildModel> getChildModelList() {
        return childModelList;
    }

    public void setChildModelList(List<ServicesChildModel> childModelList) {
        this.childModelList = childModelList;
    }
}
