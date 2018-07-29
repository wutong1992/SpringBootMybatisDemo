package com.example.demo2;

import com.example.demo2.model.StudentEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JacksonDemo {
    public static void main(String[] args) throws ParseException, IOException {
        StudentEntity student = new StudentEntity();
        student.setId(5);
        student.setName("tom");
        student.setSex("male");
        student.setAge(22);
        SimpleDateFormat dataformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        student.setBirthday(dataformat.parse("2018-12-12 08:12:12"));
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(student);
        System.out.println(json);

        List<StudentEntity> stus = new ArrayList<>();
        stus.add(student);
        String jsonlist = mapper.writeValueAsString(stus);
        System.out.println(jsonlist);

        String stu = "{\"id\":5,\"name\":\"tom\",\"age\":22,\"birthday\":\"2018-12-12 08:12:12\",\"sex\":\"male\"}";
        StudentEntity stu2 = mapper.readValue(stu,StudentEntity.class);
        System.out.println(stu2);
    }
}
