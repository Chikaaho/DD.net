package net.dd.mapper;

import mapper.DdData;

public interface DdDataMapper {
    int deleteByPrimaryKey(Long fileId);

    int insert(DdData record);

    int insertSelective(DdData record);

    DdData selectByPrimaryKey(Long fileId);

    int updateByPrimaryKeySelective(DdData record);

    int updateByPrimaryKey(DdData record);
}