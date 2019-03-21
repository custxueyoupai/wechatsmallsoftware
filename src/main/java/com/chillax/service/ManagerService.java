package com.chillax.service;

import com.chillax.dto.Manager;

public interface ManagerService {
	/**
	 * 查看教师信息
	 */
	public Manager show(String UserId);
	/**
	 * 录入教师信息
	 */
	public void save(Manager manager);
	/**
	 * 修改教师信息
	 */
	public void updata(Manager manager);
	/**
	 * 删除教师信息
	 */
	public void delete(Manager manager);

}
