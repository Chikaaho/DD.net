package net.dd.service.impl;

import net.dd.mapper.StudentLeaveMapper;
import net.dd.pojo.StudentLeave;
import net.dd.service.StudentLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Chika
 * @program DDNet
 * @create 2021/5/24 - 15:19
 **/
@Service
public class StudentLeaveServiceImpl implements StudentLeaveService {

    private StudentLeaveMapper studentLeaveMapper;

    @Autowired
    public void setStudentLeaveMapper(StudentLeaveMapper studentLeaveMapper) {
        this.studentLeaveMapper = studentLeaveMapper;
    }

    @Override
    public void start(Long studentId, String stuName, String leaveReason, Date leaveTime) {
        //studentLeaveMapper.start(studentId, stuName, leaveReason, leaveTime);
    }

    @Override
    public void approve(Integer leaveState) {

    }

//    @Override
//    public void approve(Integer leaveState) {
//        studentLeaveMapper.approve(leaveState);
//    }

    @Override
    public void end(Long leaveId) {
        studentLeaveMapper.end(leaveId);
    }

    @Override
    public StudentLeave selectByStudentId(Long studentId) {
        return null;
    }

    //@Override
//    public StudentLeave selectByStudentId(Long studentId) {
//        return studentLeaveMapper.selectByStudentId(studentId);
//    }
}