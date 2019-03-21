package com.chillax.service;

import java.util.List;

import com.chillax.dto.Student;;

public interface StudentService {
	/**
	 * 录入学生信息
	 */
	public void save(Student stu);
	/**
	 * 删除学生信息(id)
	 */
	public void delete(String stuId);
	/**
	 * 查询学生信息(id)
	 */
	public Student query(String wId);
	/**
	 * 修改学生信息(id)
	 */
	public void updata(Student student);

}
