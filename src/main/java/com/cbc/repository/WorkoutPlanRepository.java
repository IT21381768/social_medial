package com.cbc.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cbc.model.WorkoutPlan;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {
}
