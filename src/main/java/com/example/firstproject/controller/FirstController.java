package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model mo) {
        mo.addAttribute("userName", "김승원");
        return "greetings";
        //return "redirect:" or "forward:" = 해당 동작 실행
    }

    @GetMapping("/bye")
    public String seeYouNext(Model mo) {
        mo.addAttribute("userName", "김승원");
        return "goodbye";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

}
