package com.thinkdev.healix.model;

import java.util.List;

public class TransactionalModel {
    private String date, day, month, amount;
    private List<TransactionChildModel> childItemList;

    public TransactionalModel(String date, String day, String month, String amount, List<TransactionChildModel> childItemList) {
        this.date = date;
        this.day = day;
        this.month = month;
        this.amount = amount;
        this.childItemList = childItemList;
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

    public List<TransactionChildModel> getChildItemList() {
        return childItemList;
    }

    public void setChildItemList(List<TransactionChildModel> childItemList) {
        this.childItemList = childItemList;
    }
}
