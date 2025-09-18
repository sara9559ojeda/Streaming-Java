package com.streaming.streaming.domain.dto;

public class PlanDTO {
    
    private String namePlan;  
    private double price;
    private int durationDays;
    
    public String getNamePlan() {
        return namePlan;
    }
    public void setNamePlan(String namePlan) {
        this.namePlan = namePlan;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getDurationDays() {
        return durationDays;
    }
    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    } 
    
    
}
