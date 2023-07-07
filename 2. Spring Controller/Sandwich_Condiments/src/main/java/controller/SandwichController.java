package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/save")
    public String showCondiment() {
        return "save";
    }

    @PostMapping("/view")
    public String save(@RequestParam("condiment") String[] condiment,Model model) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < condiment.length; i++) {
            stringBuilder.append(condiment[i]);

            if(i < condiment.length - 1) {
                stringBuilder.append(",");
            }
        }
        String result = stringBuilder.toString();
        model.addAttribute("result",result);
        return "view";
    }

}
