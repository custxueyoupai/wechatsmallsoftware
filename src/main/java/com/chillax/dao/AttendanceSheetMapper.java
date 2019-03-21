package com.chillax.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import com.chillax.dto.AttendanceSheet;

@Repository
public interface AttendanceSheetMapper {
	/**
	 * 通过主键删除条目
	 * @param key
	 * @return
	 */
    int deleteByPrimaryKey(AttendanceSheet asheet);
    
    /**
     * 加入条目(一次性插入全部)
     * @param record
     * @return
     */
    int insert(AttendanceSheet record);

    /**
     * 加入条目,输入值有啥加啥
     * @param record
     * @return
     */
    int insertSelective(AttendanceSheet record);

    /**
     * 选择主键,显示相应条目
     * @param key
     * @return
     */
    AttendanceSheet selectByPrimaryKey(@Param(value="wid")String wid,@Param(value="checkInDate")String checkindate);
    /**
     * 选择日期,显示学号,人名和打卡结果
     * @param key
     * @return
     */
    
    AttendanceSheet selectByPrimaryKeyToBoolean(AttendanceSheet record);

    /**
     * 通过主键,修改相应条目,输入值有啥加啥
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(AttendanceSheet record);

    /**
     * 通过主键,修改相应条目(修改全部值)
     * @param record
     * @return
     */
    int updateByPrimaryKey(AttendanceSheet record);
    /**
     * 通过wid显示所有时间的签到表
     */
    List<AttendanceSheet> selectHistoryByStuId(AttendanceSheet record);
    /**
     * 通过时间显示所有学号的签到表
     */
    AttendanceSheet selectAllstuByTime(AttendanceSheet record);
    
    
}