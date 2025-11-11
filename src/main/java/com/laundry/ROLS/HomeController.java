package com.laundry.ROLS;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class HomeController {
    @GetMapping("/")
    public String helloMember(Model model){
        model.addAttribute("data", "아빠꺼 함 만들어보자잉!!!" );
        return "index";
    }
}
