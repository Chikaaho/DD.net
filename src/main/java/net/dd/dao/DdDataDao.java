package net.dd.dao;

import generator.DdData;

public interface DdDataDao {
    int deleteByPrimaryKey(Long fileId);

    int insert(DdData record);

    int insertSelective(DdData record);

    DdData selectByPrimaryKey(Long fileId);

    int updateByPrimaryKeySelective(DdData record);

    int updateByPrimaryKey(DdData record);
}