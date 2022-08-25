package com.movies.controller;

import com.movies.security.user.CustomUserClass;
import com.movies.security.user.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistrationController {
    @Autowired
    private CustomUserService userService;

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/registerUser")
    public String registerUser(Model model, @RequestBody MultiValueMap<String, String> formData) {

        CustomUserClass user = new CustomUserClass(formData.getFirst("login"), formData.getFirst("password"));

        try {
            userService.registerUser(user);
            return "registerSuccess";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "registerFailed";
        }

    }
}
