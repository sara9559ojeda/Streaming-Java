package com.streaming.streaming.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.streaming.streaming.domain.dto.PlanDTO;
import com.streaming.streaming.infraestructure.repository.PlanRepository;

@RestController
@RequestMapping("/planes")
public class PlanController {

    @Autowired
    private PlanRepository planRepository;

    @GetMapping("/obtener")
    public List<PlanDTO> getAllPlanes() {
        return planRepository.getAll();
    }

    @GetMapping("/{id}")
    public Optional<PlanDTO> getPlanById(@PathVariable Long id) {
        return planRepository.getById(id);
    }

    @PostMapping("/")
    public PlanDTO save(@RequestBody PlanDTO planDTO) {
        return planRepository.save(planDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePlan(@PathVariable Long id) {
        planRepository.delete(id);
    }
}
