package com.example.stadium.controller;

import com.example.stadium.dto.StadiumDto;
import com.example.stadium.model.*;
import com.example.stadium.service.area.IAreaService;
import com.example.stadium.service.customer.ICustomerService;
import com.example.stadium.service.stadium.IStadiumService;
import com.example.stadium.service.stadiumType.IStadiumTypeService;
import com.example.stadium.service.timeSlot.ITimeSlotService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/stadium")
public class StadiumController {
    @Autowired
    IStadiumService stadiumService;
    @Autowired
    IAreaService areaService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IStadiumTypeService stadiumTypeService;
    @Autowired
    ITimeSlotService timeSlotService;

    @ModelAttribute("timeSlots")
    public Iterable<TimeSlot> timeSlots() {
        return timeSlotService.findAll();
    }

    @ModelAttribute("areas")
    public Iterable<Area> areas() {
        return areaService.findAll();
    }

    @ModelAttribute("stadiumTypes")
    public Iterable<StadiumType> stadiumTypes() {
        return stadiumTypeService.findAll();
    }

    @GetMapping()
    public ModelAndView showList(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "3") int size,
                                 @RequestParam() Optional<String> name
    ){
        String searchNameValue ="";
        if (name.isPresent()){
            searchNameValue = name.get();
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<Stadium> stadiumPage = stadiumService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        List<Area> areas = areaService.findAll();
        List<StadiumType> stadiumTypes = stadiumTypeService.findAll();
        List<Customer> customers = customerService.findAll();
        List<TimeSlot> timeSlots = timeSlotService.findAll();
        modelAndView.addObject("stadiumPage",stadiumPage);
        modelAndView.addObject("areas",areas);
        modelAndView.addObject("stadiumTypes",stadiumTypes);
        modelAndView.addObject("customers",customers);
        modelAndView.addObject("timeSlots",timeSlots);
        modelAndView.addObject("name",searchNameValue);
        return modelAndView ;
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("stadiumDto",new StadiumDto());
        return "/stadium/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute StadiumDto stadiumDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("messCreateFail", "Add fail");
            return "/create";
        }
        Stadium stadium = new Stadium();
        BeanUtils.copyProperties(stadiumDto, stadium);
        stadiumService.save(stadium);
        redirectAttributes.addFlashAttribute("messCreate", "Add success");
        return "redirect:/stadium";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        stadiumService.remove(id);
        return "redirect:/stadium";
    }

}
