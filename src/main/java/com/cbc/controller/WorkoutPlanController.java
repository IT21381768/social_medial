package com.cbc.controller;


import com.cbc.model.WorkoutPlan;
import com.cbc.repository.WorkoutPlanRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WorkoutPlanController {

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;
    


    @GetMapping("/addWorkoutPlan")
    public String showWorkoutPlanForm(Model model) {
        model.addAttribute("workoutPlan", new WorkoutPlan());
        return "workoutPlanForm";
    }

    @PostMapping("/addWorkoutPlan")
    public String addWorkoutPlan(@ModelAttribute WorkoutPlan workoutPlan) {
        try {
            workoutPlanRepository.save(workoutPlan);
            return "redirect:/index";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/addWorkoutPlan";
        }
    }
    
    @GetMapping("/workout-plans")
    public String index(Model model) {
      List<WorkoutPlan> workoutPlans = workoutPlanRepository.findAll();
      System.out.println("workoutPlans size: " + workoutPlans.size()); // Debug statement
      model.addAttribute("workoutPlans", workoutPlans);
      return "index";
    }



}
