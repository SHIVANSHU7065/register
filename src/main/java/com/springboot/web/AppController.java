package com.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


 import java.util.*;

 @Controller
public class AppController {
 
   @Autowired
   private UserRepository userRepo;
     
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
     model.addAttribute("user",new user());
        return "signup_form";
    }
    @PostMapping("/process_register")
    public String processRegister(user user) {
    BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
    String encodePassword =passwordEncoder.encode(user.getPassword());
    user.setPassword(encodePassword);
    userRepo.save(user);
     
    return "register_success";
    }
    @GetMapping("/list_users")
    public String viewUsersList(Model model)
    {
    List<user> listUsers=userRepo.findAll();
    model.addAttribute("listUsers",listUsers);
    
    return "users";
    }
    
    
    
} 