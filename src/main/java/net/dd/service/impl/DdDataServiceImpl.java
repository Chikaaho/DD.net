package net.dd.service.impl;

import net.dd.mapper.DdDataMapper;
import net.dd.pojo.DdData;
import net.dd.service.DdDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DdDataServiceImpl implements DdDataService {

    private DdDataMapper ddDataMapper;
    @Autowired
    public void setDdDataMapper(DdDataMapper ddDataMapper) {
        this.ddDataMapper = ddDataMapper;
    }

    @Override
    public DdData selectByFileId(long fileId) {
        return ddDataMapper.selectByFileId(fileId);
    }

    @Override
    public int updateFile(long fileId, DdData ddData) {
        return ddDataMapper.updateFile(fileId, ddData);
    }

    @Override
    public int deleteById(long fileId) {
        return ddDataMapper.deleteById(fileId);
    }

    @Override
    public void insertFile(int fileType, String fileKey) {
        ddDataMapper.insertFile(fileType, fileKey);
    }

    @Override
    public List<DdData> selectAllFile(Integer roles) {
        return ddDataMapper.selectAllFile(roles);
    }
}
