package com.chillax.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chillax.dao.StudentMapper;
import com.chillax.dto.Student;
import com.chillax.service.StudentService;
@Service("StudentService")
public class StudentServiceImpl implements StudentService{
	@Autowired
    private StudentMapper studentmapper;
	/**
	 * 录入学生信息
	 */
	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentmapper.insert(student);
	}

	/**
	 * 删除学生信息(id)
	 */
	@Override
	public void delete(String stuId) {
		// TODO Auto-generated method stub
		studentmapper.deleteByPrimaryKey(stuId);
	}

	/**
	 * 查询学生信息(id)
	 * @return 
	 */
	@Override
	public Student query(String wId) {
		return studentmapper.selectByPrimaryKey(wId);		
	}
	/**
	 * 修改学生信息(id)
	 */
	@Override
	public void updata(Student student) {
		// TODO Auto-generated method stub
		studentmapper.updateByPrimaryKey(student);
	}

}