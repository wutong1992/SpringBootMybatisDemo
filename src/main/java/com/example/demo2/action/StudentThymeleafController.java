package com.example.demo2.action;

import com.example.demo2.model.StudentEntity;
import com.example.demo2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/test")
public class StudentThymeleafController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/info")
    public String index(Model model) {
        model.addAttribute("info","student/list");
        return "index";
    }

    @GetMapping("/student")
    public String student(Model model) throws ParseException {
        StudentEntity student = new StudentEntity();
        student.setId(3);
        student.setName("tom");
        student.setSex("male");
        student.setAge(24);
        SimpleDateFormat dataformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        student.setBirthday(dataformat.parse("2018-12-12 08:12:12"));
        model.addAttribute("student",student);
        return "studentInfo";
    }

    @GetMapping("/student/list")
    public String studentList(Model model) {
        StudentEntity student = studentService.getStudentEntityById(5);
        model.addAttribute("student",student);

        List<StudentEntity> students = studentService.findAll();
        model.addAttribute("students",students);
        return "studentInfo";
    }
}
