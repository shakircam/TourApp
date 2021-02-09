package com.example.shaki.newlogin;

public class TourInformation {
    private String title,desc,budget,sDatePicker,eDatePicker;


    public TourInformation() {
    }

    public TourInformation(String title, String desc, String budget,String sDatePicker, String eDatePicker) {
        this.title = title;
        this.desc = desc;
        this.budget = budget;
        this.sDatePicker = sDatePicker;
        this.eDatePicker = eDatePicker;
    }



    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getBudget() {
        return budget;
    }
    public String getsDatePicker() {return sDatePicker;}
    public String geteDatePicker() {return eDatePicker;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

}
