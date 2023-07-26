package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import com.codegym.service.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping()
    public String display(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("songList",songList);
        return "/display";
    }

    @PostMapping("/upload")
    public String upload(@ModelAttribute Song song,
                         RedirectAttributes redirectAttributes) {
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess","Upload thanh cong");
        return "redirect:/song";
    }

}
