package com.thinkdev.healix.Singleton;

import com.thinkdev.healix.model.FilterData;

public class FilterDataHolder {
    private static FilterDataHolder instance;
    private FilterData filterData;

    private FilterDataHolder() {
    }

    public static synchronized FilterDataHolder getInstance() {
        if (instance == null) {
            instance = new FilterDataHolder();
        }
        return instance;
    }

    public FilterData getFilterData() {
        return filterData;
    }

    public void setFilterData(FilterData filterData) {
        this.filterData = filterData;
    }
}
