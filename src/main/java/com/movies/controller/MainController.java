package com.movies.controller;

import com.movies.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    VideoService videoService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("videos", videoService.get());
        return "index";
    }

}
