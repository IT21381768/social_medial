package com.cbc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cbc.model.MyUser;
import com.cbc.repository.UserRepository;

@Controller
public class ProfileController {
    
    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping("/profile/{username}")
    public String userProfile(@PathVariable("username") String username, Model model) {
        Optional<MyUser> userOptional = userRepository.findByUsername(username);
        if(userOptional.isPresent()) {
            MyUser user = userOptional.get();
            model.addAttribute("user", user);
            return "profile";
        } else {
            return "redirect:/error"; 
        }
    }
}
