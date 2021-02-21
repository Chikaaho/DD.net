package net.dd.mapper;

import mapper.DdData;

public interface DdDataMapper {
    int deleteByPrimaryKey(Long file_id);

    int insert(DdData record);

    int insertSelective(DdData record);

    DdData selectByPrimaryKey(Long file_id);

    int updateByPrimaryKeySelective(DdData record);

    int updateByPrimaryKey(DdData record);
}