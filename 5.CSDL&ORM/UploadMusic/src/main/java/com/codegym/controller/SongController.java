package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping()
    public String showList(Model model) {
        List<Song> songList = songService.showAll();
        model.addAttribute("songList",songList);
        return "/list";
    }

    @GetMapping("/add")
    public String showFormCreate(Model model) {
        model.addAttribute("song",new Song());
        return "/add";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute Song song,
                         RedirectAttributes redirectAttributes){
        songService.save(song);
        redirectAttributes.addFlashAttribute("Them moi thanh cong");
        return "redirect:/song";
    }

    @GetMapping("/{id}/update")
    public String showFormUpdate(@PathVariable int id, Model model){
        model.addAttribute("song",songService.findById(id));
        return "/update";
    }

    @PostMapping("update")
    public String update(Song song,
                         RedirectAttributes redirectAttributes){
        songService.update(song.getId(), song);
        redirectAttributes.addFlashAttribute("Update thanh cong");
        return "redirect:/song";
    }
    @PostMapping("/delete")
    public String delete(Song song,
                         RedirectAttributes redirectAttributes){
        songService.delete(song.getId());
        redirectAttributes.addFlashAttribute("mess1","Xoa thanh cong");
        return "redirect:/song";
    }

}
