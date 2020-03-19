package com.example.shaki.newlogin;

public class TourInformation {
    private String title,desc,budget;


    public TourInformation() {
    }

    public TourInformation(String title, String desc, String budget) {
        this.title = title;
        this.desc = desc;
        this.budget = budget;
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
