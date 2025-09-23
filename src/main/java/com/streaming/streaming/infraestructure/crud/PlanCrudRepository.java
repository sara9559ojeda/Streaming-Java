package com.streaming.streaming.infraestructure.crud;

import org.springframework.data.repository.CrudRepository;

import com.streaming.streaming.infraestructure.model.Plan;

public interface PlanCrudRepository extends CrudRepository<Plan, Long> {
}
