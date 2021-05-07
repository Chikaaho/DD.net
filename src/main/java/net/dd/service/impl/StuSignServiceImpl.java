package net.dd.service.impl;

import net.dd.mapper.StuSignMapper;
import net.dd.mapper.StudentMapper;
import net.dd.pojo.StuSign;
import net.dd.service.StuSignService;
import net.dd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuSignServiceImpl implements StuSignService {
    @Autowired
    StuSignMapper StuSignMapper;

    @Override
    public List<StuSign> selectStuSign() {
        return StuSignMapper.selectStuSign();
    }

    @Override
    public StuSign selectStuSignByNumber(long usernum) {
        return StuSignMapper.selectStuSignByNumber(usernum);
    }

    @Override
    public int updateStuSign(long usernum, String stusignstate) {
        return StuSignMapper.updateStuSign(usernum,stusignstate);
    }
}
