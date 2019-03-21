package com.chillax.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chillax.dto.Student;
@Repository
public interface StudentMapper {
    int deleteByPrimaryKey(String stuId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String wId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}