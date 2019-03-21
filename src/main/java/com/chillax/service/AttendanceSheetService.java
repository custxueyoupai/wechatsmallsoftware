package com.chillax.service;

import java.sql.Date;
import java.util.List;

import org.joda.time.DateTime;

import com.chillax.dto.AttendanceSheet;


public interface AttendanceSheetService {
	/**
	 * 通过id和日期查看签到情况(查看当天,历史签到记录)
	 */
	public AttendanceSheet showBystuId(String wid,String checkindate);
	/**
	 * 通过日期查看签到情况(显示规定日期内所有人的姓名,学号,专业,签到情况和备注.)
	 */
	public AttendanceSheet showByData(String checkInDate);
	/**
	 * 读取用户签到信息
	 */
	public AttendanceSheet StuCheck(AttendanceSheet asheet);
	/**
	 * 修改签到表(通过id)
	 */
	public void update(AttendanceSheet asheet);
	/**
	 * 删除签到信息(通过id)
	 */
	public void delete(AttendanceSheet  ash);
	/**
	 * 插入签到表信息
	 * @param ASheet
	 */
	public void insertCheck(AttendanceSheet ASheet);
	/**
	 * 判断是否签到成功,在签退之后调用
	 * @param stuId
	 * @param CheckInTime
	 * @return
	 */
	public boolean JudgeCheck(String stuId,String checkInDate);
	/**
	 * 通过id显示历史签到记录
	 * @param stuId
	 * @return
	 */
	public List<AttendanceSheet> showBystuIdHistory(String stuId);
	

}
