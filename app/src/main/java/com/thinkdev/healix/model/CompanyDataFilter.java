package com.thinkdev.healix.model;

public class CompanyDataFilter {

    private String paymentStatus;
    private String monthYear;

    public CompanyDataFilter(String paymentStatus, String monthYear) {
        this.paymentStatus = paymentStatus;
        this.monthYear = monthYear;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(String monthYear) {
        this.monthYear = monthYear;
    }
}
