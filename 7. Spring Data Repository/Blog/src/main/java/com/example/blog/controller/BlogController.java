package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping()
    public ModelAndView showList(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "2") int size,
                                 @RequestParam()Optional<String> name
    ){
        String searchNameValue ="";
        if (name.isPresent()){
            searchNameValue = name.get();
        }
        Pageable pageable = PageRequest.of(page,size, Sort.by("name").ascending().and(Sort.by("id").ascending()));
        Page<Blog> blogPage = blogService.findAll(pageable,searchNameValue);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogPage",blogPage);
        modelAndView.addObject("name",searchNameValue);
        return modelAndView ;
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog,
                         RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess","add thanh cong");
        return "redirect:/blog";
    }

    @GetMapping("/detail")
    public String showFormDetail(@PathVariable int id,Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "detail";
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam String name) {
        List<Blog> blogList = blogService.searchName(name);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogList",blogList);
        return modelAndView;
    }
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("messUpdate","Update thanh cong");
        return "redirect:/blog";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("messDelete","Delete thanh cong");
        return "redirect:/blog";
    }


}
