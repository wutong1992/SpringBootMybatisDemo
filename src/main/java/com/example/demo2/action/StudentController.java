package com.example.demo2.action;

import com.example.demo2.common.UserNameNotMatchPasswordException;
import com.example.demo2.model.StudentEntity;
import com.example.demo2.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/find")
    @ResponseStatus(HttpStatus.OK)
    public StudentEntity find(@RequestParam("id") Integer id) {
        logger.info("find method is starting...");
        StudentEntity stu = studentService.getStudentEntityById(id);
        if(stu != null) {
            logger.info("student name is " + stu.getName());
        }
        else {
            logger.info("student is null!");
        }
        return stu;
    }

    @GetMapping(value = "findAll")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentEntity> findAll() {
        return studentService.findAll();
    }

    @GetMapping(value = "delete")
    public String deleteStu(@RequestParam("id") Integer id) {
       Integer flag = studentService.remove(studentService.getStudentEntityById(id));
       logger.info("flag:"+flag.toString());
       return "删除成功！";
    }

    @GetMapping(value = "update")
    @ResponseStatus(HttpStatus.OK)
    public String updateStu() {
        StudentEntity stu = new StudentEntity();
        stu.setId(4);
        stu.setAge(88);
        studentService.update(stu);
        return "更新成功！";
    }

    @GetMapping(value = "add")
    @ResponseStatus(HttpStatus.OK)
    public String add() {
        StudentEntity stu = new StudentEntity();
        stu.setId(5);
        stu.setAge(33);
        stu.setName("tao");
        stu.setSex("female");
        stu.setBirthday(new Date());
        studentService.save(stu);
        return "添加成功！";
    }

    @GetMapping(value = "/hello")
    @ResponseStatus(HttpStatus.OK)
    public String hello() {
        return "hello world!";
    }

    @RequestMapping(value = "/test")
    public String testException(@RequestParam("i") int i) {
        if(i==13) {
            throw new UserNameNotMatchPasswordException();
        }
        return "success";
    }

    @RequestMapping(value = "/test1")
    @ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "测试")
    public String test1Exception(@RequestParam("i") int i) {
        if(i==13) {
            throw new UserNameNotMatchPasswordException();
        }
        return "success";
    }

    @RequestMapping(value = "/page")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentEntity> pageList(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        return studentService.getList(pageNum,pageSize);
    }

    @RequestMapping(value = "/error")
    @ResponseStatus(HttpStatus.OK)
    public String error() {
        int a = 1/0;
        return "success";
    }

    @Autowired
    private StringRedisTemplate strRedis;

    @RequestMapping(value = "/redis")
    public String testRedis() {
        strRedis.opsForValue().set("zhu-cache","hello world!");
        return strRedis.opsForValue().get("zhu-cache");
    }

}
