package com.chillax.dao;
import com.chillax.dto.Notice;
public interface NoticeDao {


   public  void deleteByPrimaryKey(Notice notice);
   public void insert(Notice notice);
  // public  Notice selectByPrimaryKey(String userid,String time);
   public  Notice  query(Notice notice);
   public void updateByPrimaryKey(Notice notice);
}