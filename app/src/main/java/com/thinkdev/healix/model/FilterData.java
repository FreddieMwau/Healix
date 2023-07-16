package com.thinkdev.healix.model;

public class FilterData {

    private String companyText;
    private String paymentStatus;
    private String monthYear;

    public FilterData(String companyText, String paymentStatus, String monthYear) {
        this.companyText = companyText;
        this.paymentStatus = paymentStatus;
        this.monthYear = monthYear;
    }

    public String getCompanyText() {
        return companyText;
    }

    public void setCompanyText(String companyText) {
        this.companyText = companyText;
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
