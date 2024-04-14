package com.cbc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cbc.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	@Query("SELECT c FROM Comment c WHERE c.workoutPlan.id = :workoutPlanId")
    List<Comment> findByWorkoutPlanId(@Param("workoutPlanId") Long workoutPlanId);
}
