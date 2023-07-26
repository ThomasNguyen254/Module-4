package com.codegym.formsignin.controller;

import com.codegym.formsignin.dto.UserDto;
import com.codegym.formsignin.model.User;
import com.codegym.formsignin.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping()
    public String host() {
        return "/host";
    }

    @GetMapping("/create")
    public String showFormSignUp(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute UserDto userDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userService.save(user);
        redirectAttributes.addFlashAttribute("mess","add thanh cong");
        return "redirect:/user";
    }


}
