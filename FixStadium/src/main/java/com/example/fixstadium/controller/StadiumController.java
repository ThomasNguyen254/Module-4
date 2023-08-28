package com.example.fixstadium.controller;

import com.example.fixstadium.dto.StadiumDto;
import com.example.fixstadium.model.*;
import com.example.fixstadium.service.area.IAreaService;
import com.example.fixstadium.service.customer.ICustomerService;
import com.example.fixstadium.service.stadium.IStadiumService;
import com.example.fixstadium.service.timeslot.ITimeSlotService;
import com.example.fixstadium.service.type.ITypeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    ITypeService typeService;
    @Autowired
    ITimeSlotService timeSlotService;

    @ModelAttribute("areas")
    public Iterable<Area> areas() {
        return areaService.findAll();
    }
    @ModelAttribute("customers")
    public Iterable<Customer> customers() {
        return customerService.findAll();
    }
    @ModelAttribute("areas")
    public Iterable<TimeSlot> timeSlots() {
        return timeSlotService.findAll();
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
        List<Type> types = typeService.findAll();
        List<Customer> customers = customerService.findAll();
        List<TimeSlot> timeSlots = timeSlotService.findAll();
        modelAndView.addObject("stadiumPage",stadiumPage);
        modelAndView.addObject("areas",areas);
        modelAndView.addObject("types",types);
        modelAndView.addObject("customers",customers);
        modelAndView.addObject("timeSlots",timeSlots);
        modelAndView.addObject("name",searchNameValue);
        return modelAndView ;
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("stadiumDto",new StadiumDto());
        return "/create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute StadiumDto stadiumDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("mess", "Add fail");
            return "/create";
        }
        Stadium stadium = new Stadium();
        BeanUtils.copyProperties(stadiumDto, stadium);
        stadiumService.save(stadium);
        redirectAttributes.addFlashAttribute("mess", "Add success");
        return "redirect:/stadium";
    }
    @GetMapping("/{id}/delete/")
    public String delete(@PathVariable Long id, Model model) {
        stadiumService.remove(id);
        return "redirect:/stadium";
    }
    @GetMapping("/searchAll")
    public String searchAll(@RequestParam(value = "type", defaultValue = "") Type type,
                            @RequestParam(value = "area", defaultValue = "") Area area,
                            @RequestParam("name") Optional<String> OName,
                            @RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "3") int size,
                            Model model) {
        String nameValue = "";
        if (OName.isPresent()) {
            nameValue = OName.get();
        }
        Pageable pageable = PageRequest.of(page, size);
//        if (type == null && nameValue =="") {
//            Page<Stadium> stadiumPage = stadiumService.findByArea(pageable,area);
//            List<Area> areas = areaService.findAll();
//            List<Type> types = typeService.findAll();
//            List<Customer> customers = customerService.findAll();
//            List<TimeSlot> timeSlots = timeSlotService.findAll();
//            model.addAttribute("stadiumPage",stadiumPage);
//            model.addAttribute("areas",areas);
//            model.addAttribute("types",types);
//            model.addAttribute("customers",customers);
//            model.addAttribute("timeSlots",timeSlots);
//            return "/list";
//        }
//        if (type == null && nameValue == "") {
//            List<Area> areas = areaService.findAll();
//            List<Type> types = typeService.findAll();
//            model.addAttribute("type", types);
//            model.addAttribute("area", areas);
//            return "/list";
//        }
//        if (area == null && nameValue == "") {
//            List<Type> types = typeService.findAll();
//            List<Area> areas = areaService.findAll();
//            model.addAttribute("type", types);
//            model.addAttribute("area", areas);
//            return "/list";
//        }
        Page<Stadium> stadiumPage = stadiumService.findAllByNameContainingAndAreaAndType(pageable, nameValue, area, type);
        List<Type> types = typeService.findAll();
        List<Area> areas = areaService.findAll();
        model.addAttribute("type", types);
        model.addAttribute("area", areas);
        model.addAttribute("stadiumPage", stadiumPage);
        return "/list";
    }
    @GetMapping("/searchArea")
    public ModelAndView search(@ModelAttribute("area") Area area) {
        List<Stadium> areas = stadiumService.findAllByArea(area);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("areas",areas);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetailForm(@PathVariable Long id) {
        Optional<Stadium> stadium = stadiumService.findById(id);
        if (stadium.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/detail");
            modelAndView.addObject("stadium", stadium.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }


}
