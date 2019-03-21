package com.chillax.service.Impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chillax.service.NoticeService;
import com.chillax.dao.NoticeDao;
import com.chillax.dto.Notice;

@Service("noticeservice")
public  class NoticeServiceImpl implements NoticeService{
	
	
	@Autowired
	private NoticeDao noticedao;
	
	/**
	 * 录入通知信息
	 */
	@Override
	public void insert(Notice notice) {
		// TODO Auto-generated method stub
		noticedao.insert(notice);
		
	}
	/**
	 * 显示历史通知记录(待实现)
	 */
	@Override
	public Notice show(Notice notice) {
		// TODO Auto-generated method stub
		Notice notice1=noticedao.query(notice);
		return notice;
	}

	/**
	 * 修改通知记录(通过userId)
	 */
    @Override
	public void updata(Notice notice) {
	
		noticedao.updateByPrimaryKey(notice);
	
	}
	/**
	 * 查询通知记录(userId为登录教师的id,查询通过时间来查询)
	 */
	@Override
	public Notice query(Notice notice) {
		// TODO Auto-generated method stub
		Notice notice1=noticedao.query(notice);
		return notice1;
	}

	/**
	 * 删除通知记录((userId为登录教师的id,删除通过时间来查询)
	 */
	@Override
	public void delete(Notice notice) {
		// TODO Auto-generated method stub
		
		noticedao.deleteByPrimaryKey(notice);	
	}

	

	

}
