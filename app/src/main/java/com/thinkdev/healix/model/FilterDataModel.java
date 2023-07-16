package com.thinkdev.healix.model;

public class FilterDataModel {
    private String filterTitle, selectedValue;

    public FilterDataModel(String filterTitle, String selectedValue) {
        this.filterTitle = filterTitle;
        this.selectedValue = selectedValue;
    }

    public String getFilterTitle() {
        return filterTitle;
    }

    public void setFilterTitle(String filterTitle) {
        this.filterTitle = filterTitle;
    }

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }
}
