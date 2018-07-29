package com.example.demo2;

import com.example.demo2.model.StudentEntity;
import com.example.demo2.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentServiceTest {

    @Resource
    StudentService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findTest() {
        List<StudentEntity> stus = service.findAll();
        Assert.assertNotNull(stus);
        Assert.assertNotEquals(stus, true);
        Assert.assertNotEquals(stus, false);
    }

    @Test
    public void helloTest() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/student/hello"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("hello world!"));
        } catch (Exception e) {
            System.out.println("hello");
        }
    }
}
