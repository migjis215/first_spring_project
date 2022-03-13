package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    String username = "Minjun";

    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {

        model.addAttribute("username", username);

        return "greetings"; // templates/greetings.mustache
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model) {

        model.addAttribute("username", username);

        return "goodbye";
    }
}
