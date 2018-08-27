package com.example.demo2.action;

import com.example.demo2.common.AsyncTask;
import com.example.demo2.common.ResultUtil;
import com.example.demo2.common.StudentException;
import com.example.demo2.common.UserNameNotMatchPasswordException;
import com.example.demo2.model.ResultEntity;
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
import java.util.concurrent.Future;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/find")
    @ResponseStatus(HttpStatus.OK)
    public ResultEntity find(@RequestParam("id") Integer id) throws Exception {
        logger.info("find method is starting...");
        StudentEntity stu = studentService.getStudentEntityById(id);
        if(stu != null) {
            logger.info("student name is " + stu.getName());
        }
        else {
            logger.info("student is null!");
            if (id == 6) {
                throw new StudentException(106,"没有要查找的6号用户！");
            } else if (id == 7) {
                throw new StudentException(107,"没有要查找的7号用户！");
            } else {
                throw new Exception("没有要查找的其他用户！");
            }
        }
        return ResultUtil.success(stu);
    }

    @GetMapping(value = "findAll")
    @ResponseStatus(HttpStatus.OK)
    public ResultEntity findAll() {
        return ResultUtil.success(studentService.findAll());
    }

    @GetMapping(value = "delete")
    public ResultEntity deleteStu(@RequestParam("id") Integer id) {
       Integer flag = studentService.remove(studentService.getStudentEntityById(id));
       logger.info("flag:"+flag.toString());
       return ResultUtil.success();
    }

    @GetMapping(value = "update")
    @ResponseStatus(HttpStatus.OK)
    public ResultEntity updateStu() {
        StudentEntity stu = new StudentEntity();
        stu.setId(4);
        stu.setAge(88);
        studentService.update(stu);
        return ResultUtil.success();
    }

    @GetMapping(value = "add")
    @ResponseStatus(HttpStatus.OK)
    public ResultEntity add() {
        StudentEntity stu = new StudentEntity();
        stu.setId(5);
        stu.setAge(33);
        stu.setName("tao");
        stu.setSex("female");
        stu.setBirthday(new Date());
        studentService.save(stu);
        return ResultUtil.success();
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

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping(value = "/async")
    public String asyncTest() throws Exception {
        long start = System.currentTimeMillis();

        Future<Boolean> a = asyncTask.doTask11();
        Future<Boolean> b = asyncTask.doTask22();
        Future<Boolean> c = asyncTask.doTask33();

        while (!a.isDone() || !b.isDone() || !c.isDone()) {
            if(a.isDone() && b.isDone() && c.isDone()) {
                break;
            }
        }

        long end = System.currentTimeMillis();

        String times = "任务全部完成，总耗时：" + (end - start) + "毫秒！";
        System.out.println(times);
        return times;
    }

}
