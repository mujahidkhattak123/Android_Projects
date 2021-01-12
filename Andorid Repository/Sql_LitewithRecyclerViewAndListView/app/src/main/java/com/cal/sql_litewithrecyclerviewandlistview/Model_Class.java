package com.cal.sql_litewithrecyclerviewandlistview;

public class Model_Class {

    private int id;
    private String mname;
    private String musername;
    private String memail;
    private String mphno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMusername() {
        return musername;
    }

    public void setMusername(String musername) {
        this.musername = musername;
    }

    public String getMemail() {
        return memail;
    }

    public void setMemail(String memail) {
        this.memail = memail;
    }

    public String getMphno() {
        return mphno;
    }

    public void setMphno(String mphno) {
        this.mphno = mphno;
    }

    public Model_Class(int id, String mname, String musername, String memail, String mphno) {
        this.id = id;
        this.mname = mname;
        this.musername = musername;
        this.memail = memail;
        this.mphno = mphno;
    }

    public Model_Class(){}
}
