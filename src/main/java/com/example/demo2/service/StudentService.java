package com.example.demo2.service;

import com.example.demo2.model.StudentEntity;

import java.util.List;

public interface StudentService {

    int save(StudentEntity studentEntity);

    int update(StudentEntity studentEntity);

    int remove(StudentEntity studentEntity);

    StudentEntity getStudentEntityById(Integer id);

    List<StudentEntity> findAll();

    List<StudentEntity> getList(Integer pageNum, Integer pageSize);
}
