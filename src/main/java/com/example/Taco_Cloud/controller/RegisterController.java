package com.example.Taco_Cloud.controller;

import com.example.Taco_Cloud.model.RegistrationForm;
import com.example.Taco_Cloud.repository.UserReposiroty;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private UserReposiroty userReposiroty;
    private PasswordEncoder passwordEncoder;

    public RegisterController(UserReposiroty userReposiroty, PasswordEncoder passwordEncoder) {
        this.userReposiroty = userReposiroty;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping
    private String registerForm(){
        return "register";
    }
    @PostMapping
    private String processRegister(RegistrationForm form){
        userReposiroty.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
