package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller

public class Controller {
    @GetMapping("/view")
    public String showFormCaculator(){
        return "view";
    }

    @PostMapping("/view")
    public String change(Model model,String USD,String rate){
        Float result =  Float.parseFloat(rate) * Float.parseFloat(USD);
        model.addAttribute("result",result);
        return "view";
    }

}
