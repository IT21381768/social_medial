package com.cbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cbc.model.Comment;
import com.cbc.model.WorkoutPlan;
import com.cbc.model.WorkoutPlanStatus;
import com.cbc.repository.WorkoutPlanRepository;
import com.cbc.repository.WorkoutPlanStatusRepository;

@Controller
public class WorkoutPlanStatusController {
    
    @Autowired
    private WorkoutPlanStatusRepository workoutPlanStatusRepository;
    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;
    
    @GetMapping("/addWorkoutPlanStatus/{workoutPlanId}")
    public String showWorkoutPlanStatusForm(@PathVariable Long workoutPlanId, Model model) {
        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setId(workoutPlanId);
        model.addAttribute("workoutPlanStatus", workoutPlan);
        return "workoutPlanStatusForm";
    }
    
    @PostMapping("/addWorkoutPlanStatus/{workoutPlanId}")
    public String addWorkoutPlanStatus(@PathVariable Long workoutPlanId, @ModelAttribute WorkoutPlanStatus workoutPlanStatus) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = ((UserDetails) authentication.getPrincipal()).getUsername();
            
            workoutPlanStatus.setUsername(username);
            
            WorkoutPlan workoutPlan = new WorkoutPlan();
            workoutPlan.setId(workoutPlanId);
            workoutPlanStatus.setWorkoutPlan(workoutPlan);
            
            workoutPlanStatusRepository.save(workoutPlanStatus);
            
            return "redirect:/index";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/addWorkoutPlan";
        }
    }
    
    @GetMapping("/workout-plan-status")
    public String displayWorkoutPlanStatus(Model model) {
    	model.addAttribute("workoutPlans", workoutPlanRepository.findAll());
        model.addAttribute("workoutPlanStatus", workoutPlanStatusRepository.findAll());
        return "workoutPlanStatus";
    }

}
