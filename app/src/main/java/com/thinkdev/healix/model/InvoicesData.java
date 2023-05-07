package com.thinkdev.healix.model;

public class InvoicesData {

    private String invTitle;
    private String nameTv;
    private String subnameTv;
    private String desTv;

    public String getInvdate() {
        return invdate;
    }

    public void setInvdate(String invdate) {
        this.invdate = invdate;
    }

    private String invdate;

    public String getInvTitle() {
        return invTitle;
    }

    public void setInvTitle(String invTitle) {
        this.invTitle = invTitle;
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

    public String getDesTv() {
        return desTv;
    }

    public void setDesTv(String desTv) {
        this.desTv = desTv;
    }

    public String getBtnstatus() {
        return btnstatus;
    }

    public void setBtnstatus(String btnstatus) {
        this.btnstatus = btnstatus;
    }

    private String btnstatus;


    public InvoicesData(String desTv, String subnameTv, String nameTv, String invTitle, String btnstatus, String invdate) {
        this.desTv = desTv;
        this.subnameTv = subnameTv;
        this.nameTv = nameTv;
        this.invTitle = invTitle;
        this.btnstatus = btnstatus;
        this.invdate = invdate;
    }

}

