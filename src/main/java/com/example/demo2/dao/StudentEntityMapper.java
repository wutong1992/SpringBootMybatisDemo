package com.example.demo2.dao;

import com.example.demo2.model.StudentEntity;
import org.apache.ibatis.annotations.Mapper;

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
}