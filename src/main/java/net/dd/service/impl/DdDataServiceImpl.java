package net.dd.service.impl;

import mapper.DdData;
import net.dd.mapper.DdDataMapper;
import net.dd.service.DdDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DdDataServiceImpl implements DdDataService {

    @Resource
    private DdDataMapper ddDataMapper;

    @Override
    public int deleteByPrimaryKey(Long fileId) {
        return ddDataMapper.deleteByPrimaryKey(fileId);
    }

    @Override
    public int insert(DdData record) {
        return ddDataMapper.insert(record);
    }

    @Override
    public int insertSelective(DdData record) {
        return ddDataMapper.insertSelective(record);
    }

    @Override
    public DdData selectByPrimaryKey(Long fileId) {
        return ddDataMapper.selectByPrimaryKey(fileId);
    }

    @Override
    public int updateByPrimaryKeySelective(DdData record) {
        return ddDataMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DdData record) {
        return ddDataMapper.updateByPrimaryKey(record);
    }
}
