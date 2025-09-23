package com.streaming.streaming.infraestructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.streaming.streaming.domain.dto.PlanDTO;
import com.streaming.streaming.domain.irepository.IPlanRepository;
import com.streaming.streaming.infraestructure.crud.PlanCrudRepository;
import com.streaming.streaming.infraestructure.mapper.PlanMapper;
import com.streaming.streaming.infraestructure.model.Plan;

@Repository
public class PlanRepository implements IPlanRepository {

    @Autowired
    private PlanCrudRepository crud;

    @Autowired
    private PlanMapper mapper;

    @Override
    public List<PlanDTO> getAll() {
        List<Plan> planes = (List<Plan>) crud.findAll();
        return mapper.toDTOPlans(planes);
    }

    @Override
    public PlanDTO save(PlanDTO planDTO) {
        Plan plan = mapper.toEntityPlan(planDTO);
        Plan saved = crud.save(plan);
        return mapper.toDTOPlan(saved);
    }

    @Override
    public Optional<PlanDTO> getById(Long id) {
        return crud.findById(id)
                   .map(mapper::toDTOPlan);
    }

    @Override
    public void delete(Long id) {
        crud.deleteById(id);
    }
}
