package com.example.demo2.service;

import com.example.demo2.model.ClazzEntity;
import com.example.demo2.model.StudentEntity;
import com.example.demo2.model.TeacherEntity;

import java.util.HashMap;
import java.util.List;

public interface StudentService {

    int save(StudentEntity studentEntity);

    int update(StudentEntity studentEntity);

    int remove(StudentEntity studentEntity);

    StudentEntity getStudentEntityById(Integer id);

    List<StudentEntity> findAll();

    List<StudentEntity> getList(Integer pageNum, Integer pageSize);

    List<TeacherEntity> findAllTeachers();

    List<ClazzEntity> findAllClazzs();

    List<TeacherEntity> findTeachersClazz1(HashMap<String,Object> params);

    List<TeacherEntity> findTeachersIn(List<Integer> Ids);
}
