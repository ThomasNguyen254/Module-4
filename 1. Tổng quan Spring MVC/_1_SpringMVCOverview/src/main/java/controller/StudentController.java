package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.IStudentService;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/student")
    public String showList(Model model) {
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList",studentList);
        return "list";
    }

}
