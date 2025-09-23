package com.streaming.streaming.domain.irepository;

import java.util.List;
import java.util.Optional;

import com.streaming.streaming.domain.dto.PlanDTO;

public interface IPlanRepository {
    List<PlanDTO> getAll();
    PlanDTO save(PlanDTO planDTO);
    Optional<PlanDTO> getById(Long id);
    void delete(Long id);
}
