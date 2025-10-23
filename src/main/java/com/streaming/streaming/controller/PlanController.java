package com.streaming.streaming.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.streaming.streaming.domain.dto.PlanDTO;
import com.streaming.streaming.domain.service.PlanService;

@RestController
@RequestMapping("/planes")
public class PlanController {

    @Autowired
    private PlanService planService;

    // ✅ Obtener todos los planes
    @GetMapping(value = "/obtener", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<PlanDTO>> getAllPlanes() {
        List<PlanDTO> planes = planService.obtenerTodo();
        return ResponseEntity.ok(planes);
    }

    // ✅ Obtener un plan por ID
    @GetMapping(value = "/{id}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> getPlanById(@PathVariable Long id) {
        Optional<PlanDTO> plan = planService.obtenerPorId(id);
        if (plan.isPresent()) {
            return ResponseEntity.ok(plan.get());
        } else {
            return ResponseEntity.status(404).body("No se encontró el plan con ID " + id);
        }
    }

    // ✅ Guardar o actualizar plan
    @PostMapping(value = "/", produces = "text/plain; charset=UTF-8")
    public ResponseEntity<String> save(@RequestBody PlanDTO planDTO) {
        String mensaje = planService.guardar(planDTO);
        return ResponseEntity.status(200).body(mensaje);
    }

    // ✅ Eliminar plan por ID
    @DeleteMapping(value = "/{id}", produces = "text/plain; charset=UTF-8")
    public ResponseEntity<String> deletePlan(@PathVariable Long id) {
        String mensaje = planService.eliminar(id);
        return ResponseEntity.status(200).body(mensaje);
    }
}
