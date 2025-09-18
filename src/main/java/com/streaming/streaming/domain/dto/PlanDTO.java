package com.streaming.streaming.domain.dto;

public class PlanDTO {
    
    private Long id;

    private String namePlan;  
    private Double price;
    private Integer durationDays;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNamePlan() {
        return namePlan;
    }
    public void setNamePlan(String namePlan) {
        this.namePlan = namePlan;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getDurationDays() {
        return durationDays;
    }
    public void setDurationDays(Integer durationDays) {
        this.durationDays = durationDays;
    }
    
}
