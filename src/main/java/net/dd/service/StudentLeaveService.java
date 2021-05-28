package net.dd.service;

import net.dd.pojo.StudentLeave;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author Chika
 * @program DDNet
 * @create 2021/5/24 - 14:57
 **/

public interface StudentLeaveService {

    void start(@Param("studentId") Long studentId, @Param("stuName") String stuName, @Param("leaveSeason") String leaveReason, Date leaveTime);

    void approve(Integer leaveState);

    void end(Long leaveId);

    StudentLeave selectByStudentId(Long studentId);

}