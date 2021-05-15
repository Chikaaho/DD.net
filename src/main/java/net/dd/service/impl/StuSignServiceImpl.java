package net.dd.service.impl;

import net.dd.mapper.StuSignMapper;
import net.dd.mapper.StudentMapper;
import net.dd.pojo.SignPlan;
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
    public List<StuSign> selectStuSignBySignId(long signid,String classname,String coursename) {
        return StuSignMapper.selectStuSignBySignId(signid,classname,coursename);
    }

    @Override
    public List<SignPlan> selectStuSignPlanBysignstate(long signid, String classname, long signstate) {
        return StuSignMapper.selectStuSignPlanBysignstate(signid,classname,signstate);
    }

    @Override
    public List<StuSign> selectStuSignByNumber(long usernum,String coursename) {
        return StuSignMapper.selectStuSignByNumber(usernum,coursename);
    }

    @Override
    public StuSign selectONEStuSign(long stunum, long signid, String coursename) {
        return StuSignMapper.selectONEStuSign(stunum,signid,coursename);
    }

    @Override
    public int updatesignplan(long signid, long signstate, String classname, String coursename) {
        return StuSignMapper.updatesignplan(signid,signstate,classname,coursename);
    }

    @Override
    public int updateStuSign(long stunum, long signid, String coursename) {
        StuSign stuSign =  StuSignMapper.selectONEStuSign(stunum,signid,coursename);
        if(stuSign.getStusignstate().equals("未签到")) return StuSignMapper.updateStuSign(stunum,signid,coursename);
        else return 0;
    }

    @Override
    public int teaupdatasign(long stunum, long signid, String stusignstate) {
        return StuSignMapper.teaupdatasign(stunum,signid,stusignstate);
    }

    @Override
    public List<SignPlan> selectOneSignPlan(long signid, String classname, String coursename) {
        return StuSignMapper.selectOneSignPlan(signid,classname,coursename);
    }

    @Override
    public int insertSignPlan(String classname, int signstate, long signid, String coursename) {
        return StuSignMapper.insertSignPlan(classname,signstate,signid,coursename);
    }

    @Override
    public int insertStuSign(long stunum, String stuname, long signid, String stusignstate,String coursename,String classname) {
        return StuSignMapper.insertStuSign(stunum,stuname,signid,stusignstate,coursename,classname);
    }


}
