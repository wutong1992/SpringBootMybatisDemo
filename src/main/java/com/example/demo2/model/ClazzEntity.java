package com.example.demo2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClazzEntity {
    private Integer id;
    private String code;
    private List<TeacherEntity> teachers;
}
