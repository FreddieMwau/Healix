package com.thinkdev.healix.model;

public class AddServicesData {

    private String paytotal;
    private String nameTv;

    public String getPaytotal() {
        return paytotal;
    }

    public void setPaytotal(String paytotal) {
        this.paytotal = paytotal;
    }

    public String getNameTv() {
        return nameTv;
    }

    public void setNameTv(String nameTv) {
        this.nameTv = nameTv;
    }

    public String getSubnameTv() {
        return subnameTv;
    }

    public void setSubnameTv(String subnameTv) {
        this.subnameTv = subnameTv;
    }

    private String subnameTv;


    public AddServicesData( String subnameTv, String nameTv, String paytotal) {

        this.subnameTv = subnameTv;
        this.nameTv = nameTv;
        this.paytotal = paytotal;

    }

}

