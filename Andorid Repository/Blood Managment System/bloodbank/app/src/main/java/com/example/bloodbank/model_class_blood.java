package com.example.bloodbank;

/**
 * Created by Belal on 9/5/2017.
 */

public class model_class_blood {
    String Camp_Adress_, Camp_Name,Camp_id,Camp_details;

    public model_class_blood( String Camp_Name,String Camp_Adress_, String Camp_id,String Camp_details) {
        this.Camp_Adress_ = Camp_Adress_;
        this.Camp_Name = Camp_Name;
        this.Camp_id=Camp_id;
        this.Camp_details=Camp_details;
    }

    public String getCamp_Adress_() {
        return Camp_Adress_;
    }
    public String getCamp_id() {
        return Camp_id;
    }
    public String getCamp_Name() {
        return Camp_Name;
    }
    public String getCamp_details() {
        return Camp_details;
    }




}
