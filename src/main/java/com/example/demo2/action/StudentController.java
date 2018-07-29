package com.example.demo2.action;

import com.example.demo2.model.StudentEntity;
import com.example.demo2.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/find")
    @ResponseStatus(HttpStatus.OK)
    public StudentEntity find() {
        logger.info("find method is starting...");
        StudentEntity stu = studentService.getStudentEntityById(5);
        if(stu != null) {
            logger.info("student name is " + stu.getName());
        }
        else {
            logger.info("student is null!");
        }
        return stu;
    }

    @GetMapping(value = "/hello")
    @ResponseStatus(HttpStatus.OK)
    public String hello() {
        return "hello world!";
    }

}
