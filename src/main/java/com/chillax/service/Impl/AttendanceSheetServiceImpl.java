package com.chillax.service.Impl;

import java.sql.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chillax.dto.AttendanceSheet;
import com.chillax.service.AttendanceSheetService;
import com.chillax.dao.AttendanceSheetMapper;


@Service("AttendanceSheetService")
public class AttendanceSheetServiceImpl implements AttendanceSheetService{
	
	@Autowired
	private AttendanceSheetMapper ASheetMapper;

	/**
	 * 通过id查看签到情况(查看当天)
	 */
	@Override
	public AttendanceSheet showBystuId(String wid,String checkindate) {
		// TODO Auto-generated method stub
		 return ASheetMapper.selectByPrimaryKey(wid,checkindate);

	}
	
	/**
	 * 通过id查看历史签到情况
	 * 输入Id出现该id所有时间的数据
	 */
	@Override
	public List<AttendanceSheet> showBystuIdHistory(String wid) {
		AttendanceSheet ASheet = new AttendanceSheet();
		ASheet.setwId(wid);
		return ASheetMapper.selectHistoryByStuId(ASheet);

	}
	
	/**
	 * 通过日期查看签到情况(暂时:显示单一日期的签到情况)
	 * 理想操作(待实现):
	 * (显示规定日期内所有人的姓名,学号,专业,签到情况和备注.)
	 * 输入checkIntime,只比较date部分,把date部分相同数据显示出来
	 */
	@Override
	public AttendanceSheet showByData(String checkInTime) {
		// TODO Auto-generated method stub
		AttendanceSheet ASheet = new AttendanceSheet();
        ASheet.setCheckInTime(checkInTime);
		return ASheetMapper.selectAllstuByTime(ASheet);
	}
	/**
	 * 读取用户打卡情况(通过学生id和时间查询)
	 */
	@Override
	public AttendanceSheet StuCheck(AttendanceSheet asheet) {
		// TODO Auto-generated method stub
		AttendanceSheet ASHEET = new AttendanceSheet();
		ASHEET= ASheetMapper.selectByPrimaryKeyToBoolean(asheet);
		return ASHEET;
	}
	/**
	 * 判断用户是否完成打卡
	 * ①当checkInTime和checkInTime同时存在且date相同的,打卡情况为true,向签到表插入签到信息
	 * ②当checkInTime和checkOutTime同时存在而date不相同的,打卡情况为false,向签到表插入签到信息
	 * 备注返回"延时打卡"
	 * 在操作签退时调用此功能
	 * (待实现)
	 */
	@Override
	public boolean JudgeCheck(String stuId,String checkInDate) {
		return false;
	}
	/**
	 * 插入签到表信息
	 */
	@Override
	public void insertCheck(AttendanceSheet ASheet) {
		ASheetMapper.insertSelective(ASheet);
	}

	/**
	 * 修改签到表(通过id和时间)
	 */
	@Override
	public void update(AttendanceSheet asheet) {
		ASheetMapper.updateByPrimaryKeySelective(asheet);
	}

	/**
	 * 删除签到信息(通过id和姓名)
	 */
	@Override
	public void delete(AttendanceSheet ash) {
		// TODO Auto-generated method stub
		
		ASheetMapper.deleteByPrimaryKey(ash);
		
	}



}
