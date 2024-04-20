package com.cbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbc.model.WorkoutPlan;
import com.cbc.model.WorkoutPlanStatus;

public interface WorkoutPlanStatusRepository extends JpaRepository<WorkoutPlanStatus, Long>{

}
