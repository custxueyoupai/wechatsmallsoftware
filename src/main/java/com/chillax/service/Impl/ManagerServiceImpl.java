package com.chillax.service.Impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chillax.dao.ManagerDao;
import com.chillax.dto.Manager;
import com.chillax.service.ManagerService;


@Service("managerService")
public class ManagerServiceImpl implements ManagerService{
	
	@Resource
	private ManagerDao managermapper;

	//private getField getField;
    /**
	 * 查看教师信息
	 */
	@Override
	public Manager show(String username) {
		// TODO Auto-generated method stub
		return managermapper.selectByPrimaryKey(username);

	}
	

	/**
	 * 录入教师信息
	 */
	@Override
	public void save(Manager man) {
		// TODO Auto-generated method stub
		managermapper.insertSelective(man);
	}

	/**
	 * 修改教师信息
	 */
	@Override
	public void updata(Manager manager) {
	
		
		managermapper.updateByPrimaryKeySelective(manager);
	}

	/**
	 * 删除教师信息
	 */
	@Override
	public void delete(Manager manager) {
		// TODO Auto-generated method stub
		managermapper.deleteByPrimaryKey(manager);
	}
}