package controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/display")
    public String displayHealthDeclaration() {
        return "display";
    }

}
