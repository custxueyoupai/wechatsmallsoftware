package com.chillax.dao;

import com.chillax.dto.Manager;

public interface ManagerDao {
    int deleteByPrimaryKey(Manager manager);

    int insert(Manager manager);

    int insertSelective(Manager manager);

    Manager selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}