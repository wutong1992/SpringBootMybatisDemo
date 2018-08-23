package com.example.demo2.service;

import com.example.demo2.dao.StudentEntityMapper;
import com.example.demo2.model.StudentEntity;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentEntityMapper stuMapper;

    @Override
    public int save(StudentEntity studentEntity) {
        return stuMapper.insert(studentEntity);
    }

    @Override
    public int update(StudentEntity studentEntity) {
        return stuMapper.updateByPrimaryKeySelective(studentEntity);
    }

    @Override
    public int remove(StudentEntity studentEntity) {
        return stuMapper.deleteByPrimaryKey(studentEntity.getId());
    }

    @Override
    public StudentEntity getStudentEntityById(Integer id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<StudentEntity> findAll() {
        return stuMapper.findAll();
    }

    @Override
    public List<StudentEntity> getList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<StudentEntity> stuList = stuMapper.findAll();
        return stuList;
    }
}
