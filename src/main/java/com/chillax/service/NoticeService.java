package com.chillax.service;




import com.chillax.dto.Notice;



public interface NoticeService {
	/**
	 * 录入通知信息
	 */
	public void insert(Notice notice);
	
	/**
	 * 显示通知记录
	 */
	public Notice show(Notice notice);
	/**
	 * 修改通知记录(通过userId)
	 */
	public void updata(Notice notice);
	/**
	 * 查询通知记录(userId为登录教师的id,查询通过时间来查询)
	 */
	public Notice query(Notice notice);
	/**
	 * 删除通知记录((userId为登录教师的id,删除通过时间来查询)
	 */
	public void delete(Notice notice);

}
