package com.thinkdev.healix.model;

import java.util.List;

public class NotificationParentModel {

    private String date, day, month;
    private List<NotificationChildModel> notificationChildModelList;

    public NotificationParentModel(String date, String day, String month, List<NotificationChildModel> notificationChildModelList) {
        this.date = date;
        this.day = day;
        this.month = month;
        this.notificationChildModelList = notificationChildModelList;
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

    public List<NotificationChildModel> getNotificationChildModelList() {
        return notificationChildModelList;
    }

    public void setNotificationChildModelList(List<NotificationChildModel> notificationChildModelList) {
        this.notificationChildModelList = notificationChildModelList;
    }
}
