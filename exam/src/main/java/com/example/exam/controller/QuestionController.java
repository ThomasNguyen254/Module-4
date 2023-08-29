package com.example.exam.controller;

import com.example.exam.dto.QuestionDto;
import com.example.exam.model.Question;
import com.example.exam.model.Status;
import com.example.exam.model.Type;
import com.example.exam.service.question.IQuestionService;
import com.example.exam.service.status.IStatusService;
import com.example.exam.service.type.ITypeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    IQuestionService questionService;

    @Autowired
    IStatusService statusService;

    @Autowired
    ITypeService typeService;

    @ModelAttribute("statuses")
    public Iterable<Status> statuses() {
        return statusService.findAll();
    }

    @ModelAttribute("types")
    public Iterable<Type> types() {
        return typeService.findAll();
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("questionDto", new QuestionDto());
        return "/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute QuestionDto questionDto,
                       BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new QuestionDto().validate(questionDto,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("mess", "Thêm mới không thành công!");
            return "/create";
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionDto, question);
        questionService.save(question);
        model.addAttribute("mess", "Thêm mới thành công!!");
        return "/create";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        questionService.remove(id);
        return "redirect:/question";
    }

    @GetMapping()
    public ModelAndView listQuestions(@PageableDefault(size = 2, page = 0) Pageable pageable,
                                      @RequestParam(name = "tittleSearch", defaultValue = "", required = false) String tittleSearch,
                                      @RequestParam(name = "typeSearch", defaultValue = "", required = false) String typeSearch
    ) {

        Page<Question> questionPage = questionService.findByTittleContainingAndType_NameContaining(pageable, tittleSearch, typeSearch);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("questionPage", questionPage);
        modelAndView.addObject("tittleSearch", tittleSearch);
        modelAndView.addObject("typeSearch", typeSearch);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetailForm(@PathVariable Long id) {
        Optional<Question> question = questionService.findById(id);
        if (question.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/detail");
            modelAndView.addObject("question", question.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }


}
