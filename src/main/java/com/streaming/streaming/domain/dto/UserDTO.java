package com.streaming.streaming.domain.dto;

public class UserDTO {
    private String name;
    private String email;
    private PlanDTO planName;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public PlanDTO getPlanName() {
        return planName;
    }
    public void setPlanName(PlanDTO planName) {
        this.planName = planName;
    }
    
    
}
