package com.example.demo2.dao;

import com.example.demo2.model.ClazzEntity;
import com.example.demo2.model.StudentEntity;
import com.example.demo2.model.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface StudentEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentEntity record);

    int insertSelective(StudentEntity record);

    StudentEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentEntity record);

    int updateByPrimaryKey(StudentEntity record);

    List<StudentEntity> findAll();

    //查询所有老师信息
    List<TeacherEntity> findAllTeachers();

    //查询所有班级
    List<ClazzEntity> findAllClazzs();

    //查询班级1的老师
    List<TeacherEntity> findTeachersClazz1(HashMap<String, Object> params);

    //查询指定ID集合的老师
    List<TeacherEntity> selectTeachersIn(List<Integer> ids);
}