package com.codegym.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@org.springframework.stereotype.Controller
public class Controller {

    @ModelAttribute("languages")
    public String[] getLanguages(){
        return new String[]{"English","Japan","Germany"};
    }

    @GetMapping("/display")
    public String display() {
        return "/display";
    }


}
