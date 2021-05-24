package net.dd.mapper;

import net.dd.pojo.StudentLeave;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Chika
 * @program DDNet
 * @create 2021/5/24 - 14:57
 **/
@Mapper
@Repository
public interface StudentLeaveMapper {

    void start(@Param("studentId") Long studentId, @Param("stuName") String stuName, @Param("leaveSeason") String leaveReason);

    void approve(@Param("leaveState") Integer leaveState);

    void end(@Param("leaveId") Long leaveId);

    StudentLeave selectByStudentId(@Param("studentId") Long studentId);

}
