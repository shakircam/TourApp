package com.example.shaki.newlogin;

import java.util.Date;

public class TourInfo{

    String tourName,tourDesc,memoryCaption,expenseType;
    double startDate,endDate;
    int    tourPic;
    double tourBudget,expenseAmount;

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public void setTourDesc(String tourDesc) {
        this.tourDesc = tourDesc;
    }

    public void setMemoryCaption(String memoryCaption) {
        this.memoryCaption = memoryCaption;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public void setStartDate(double startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(double endDate) {
        this.endDate = endDate;
    }

    public void setTourPic(int tourPic) {
        this.tourPic = tourPic;
    }

    public void setTourBudget(double tourBudget) {
        this.tourBudget = tourBudget;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getTourName() {
        return tourName;
    }

    public String getTourDesc() {
        return tourDesc;
    }

    public String getMemoryCaption() {
        return memoryCaption;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public double getStartDate() {
        return startDate;
    }

    public double getEndDate() {
        return endDate;
    }

    public int getTourPic() {
        return tourPic;
    }

    public double getTourBudget() {
        return tourBudget;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }
}
