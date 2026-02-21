package com.message.SMS.Controller;

import com.message.SMS.Model.Student;
import com.message.SMS.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewController {
    private final StudentService studentService;

    public ViewController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);
        return "index";
    }
}

