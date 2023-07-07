package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/show")
    public String showCaculator() {
        return "show";
    }

    @PostMapping("/result")
    public String caculator(@RequestParam int num1,
                            @RequestParam int num2,
                            @RequestParam("operator") String operator,
                            Model model) {
        int result = 0;
        switch (operator) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                result = num1 / num2;
                break;
        }
        model.addAttribute("result", result);
        return "result";
    }

}
