package com.thinkdev.healix.Singleton;

import com.thinkdev.healix.model.CompanyDataFilter;
import com.thinkdev.healix.model.FilterData;

public class CompanyFilterDataHolder {
    private static CompanyFilterDataHolder instance;
    private CompanyDataFilter companyDataFilter;

    private CompanyFilterDataHolder() {
    }

    public static synchronized CompanyFilterDataHolder getInstance() {
        if (instance == null) {
            instance = new CompanyFilterDataHolder();
        }
        return instance;
    }

    public CompanyDataFilter getCompanyDataFilter() {
        return companyDataFilter;
    }

    public void setCompanyDataFilter(CompanyDataFilter companyDataFilter) {
        this.companyDataFilter = companyDataFilter;
    }
}
