package com.cbc.controller;


import com.cbc.model.WorkoutPlan;
import com.cbc.repository.WorkoutPlanRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Controller
public class WorkoutPlanController {

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;
    


    @GetMapping("/addWorkoutPlan")
    public String showWorkoutPlanForm(Model model) {
        model.addAttribute("workoutPlan", new WorkoutPlan());
        return "workoutPlanForm";
    }

//    @PostMapping("/addWorkoutPlan")
//    public String addWorkoutPlan(@ModelAttribute WorkoutPlan workoutPlan) {
//        try {
//            workoutPlanRepository.save(workoutPlan);
//            return "redirect:/index";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "redirect:/addWorkoutPlan";
//        }
//    }
    @PostMapping("/addWorkoutPlan")
    public String addWorkoutPlan(@ModelAttribute WorkoutPlan workoutPlan) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = ((UserDetails) authentication.getPrincipal()).getUsername();
            
            workoutPlan.setUsername(username);
            
            workoutPlanRepository.save(workoutPlan);
            
            return "redirect:/index";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/addWorkoutPlan";
        }
    }

    
    @GetMapping("/workout-plans")
    public String displayWorkoutPlans(Model model) {
        model.addAttribute("workoutPlans", workoutPlanRepository.findAll());
        return "workoutPlans";
    }
    
  
    
    //edit part
    
    @GetMapping("/editWorkoutPlan/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        WorkoutPlan workoutPlan = workoutPlanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid workout plan Id:" + id));
        model.addAttribute("workoutPlan", workoutPlan);
        return "editWorkoutPlan";
    }

    @PostMapping("/editWorkoutPlan/{id}")
    public String editWorkoutPlan(@PathVariable("id") Long id, @ModelAttribute("workoutPlan") WorkoutPlan updatedPlan) {
        WorkoutPlan workoutPlan = workoutPlanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid workout plan Id:" + id));
       
        workoutPlan.setPlanName(updatedPlan.getPlanName());
        workoutPlan.setDescription(updatedPlan.getDescription());
        workoutPlanRepository.save(workoutPlan);
        return "redirect:/workout-plans"; 
    }

  
    
    
    
    



}
