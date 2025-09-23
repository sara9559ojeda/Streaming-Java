package com.streaming.streaming.domain.dto;

public class PlanDTO {
    private Long id;
    private String nombrePlan;
    private Double precio;
    private Integer duracionDias;

    // getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombrePlan() {
        return nombrePlan;
    }
    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Integer getDuracionDias() {
        return duracionDias;
    }
    public void setDuracionDias(Integer duracionDias) {
        this.duracionDias = duracionDias;
    }
}
