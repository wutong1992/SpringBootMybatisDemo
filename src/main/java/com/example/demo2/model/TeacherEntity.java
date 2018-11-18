package com.example.demo2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeacherEntity {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private ClazzEntity clazz;
}
