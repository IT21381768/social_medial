package com.cbc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.cbc.model.Comment;
import com.cbc.model.WorkoutPlan;
import com.cbc.repository.CommentRepository;
import com.cbc.repository.WorkoutPlanRepository;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

@Controller
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    @PostMapping("/addComment/{workoutPlanId}")
    public String addComment(@PathVariable Long workoutPlanId, @RequestParam String commentText) {
        // Retrieve the currently authenticated user's username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        WorkoutPlan workoutPlan = workoutPlanRepository.findById(workoutPlanId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid workout plan ID: " + workoutPlanId));

        Comment comment = new Comment();
        comment.setUsername(username); // Set the username
        comment.setWorkoutPlan(workoutPlan);
        comment.setText(commentText);
        commentRepository.save(comment);

        return "redirect:/workout-plans";
    }
}
