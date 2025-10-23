package com.streaming.streaming.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.streaming.streaming.domain.dto.PlanDTO;
import com.streaming.streaming.domain.irepository.IPlanRepository;

@Service
public class PlanService {

    @Autowired
    private IPlanRepository planRepository;

    // ✅ Obtener todos los planes
    public List<PlanDTO> obtenerTodo() {
        return planRepository.getAll();
    }

    // ✅ Guardar un nuevo plan o actualizar uno existente
    public String guardar(PlanDTO planDTO) {
        PlanDTO savedPlan = planRepository.save(planDTO);
        if (savedPlan != null) {
            String nombre = savedPlan.getNombrePlan() != null ? savedPlan.getNombrePlan() : "sin nombre";
            return "Plan '" + nombre + "' guardado correctamente.";
        } else {
            return "Error al guardar el plan.";
        }
    }

    // ✅ Buscar un plan por ID
    public Optional<PlanDTO> obtenerPorId(Long id) {
        return planRepository.getById(id);
    }

    // ✅ Eliminar un plan por ID
    public String eliminar(Long planId) {
        Optional<PlanDTO> plan = planRepository.getById(planId);
        if (plan.isPresent()) {
            planRepository.delete(planId);
            String nombre = plan.get().getNombrePlan() != null ? plan.get().getNombrePlan() : "desconocido";
            return "Plan '" + nombre + "' eliminado correctamente.";
        } else {
            return "No se encontró un plan con ID " + planId + ".";
        }
    }
}
