package com.example.demo2;

import com.example.demo2.model.StudentEntity;
import com.example.demo2.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void findAll() {
        List<StudentEntity> stus = studentService.findAll();
        System.out.println(stus.get(0).getAge());
        Assert.assertEquals(new Integer(24),stus.get(0).getAge());
    }
}
