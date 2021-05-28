package net.dd.mapper;

import io.swagger.models.auth.In;
import net.dd.pojo.StudentLeave;
import net.dd.pojo.StudentLeaveList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Chika
 * @program DDNet
 * @create 2021/5/24 - 14:57
 **/
@Mapper
@Repository
public interface StudentLeaveMapper {
    //请假流程：1.插入申请信息，然后插入到申请列表
    //        2.学生通过申请列表查找出在申请表中的申请信息，一个学生一门课一次只能申请一次请假，等这次请假审核结束后才能再次申请
    //        3.教师审核请假申请，审核完成后，学生点击再次申请就删除  申请列表 中的信息，然后重复以上的步骤
    int start(@Param("stunum") Long stunum,  //学生提交请假申请  1-1
               @Param("stuname") String stuname,
               @Param("classname") String classname,
               @Param("coursename") String coursename,
               @Param("leavereason") String leavereason,
               @Param("leavetime") Date leavetime);

    int acceptleave(Integer leaveState);  //教师审核 通过
    int rejectleave(Integer leaveState);  //教师审核 驳回

    void end(Long leaveId);

    int leaveid();  //1-2

    StudentLeave selectleave(@Param("leaveid") Integer leaveid);//学生查看请假申请 2-2

    int leavelist(@Param("leaveid") Integer leaveid,  //学生请假申请后插入到请假表 1-3
                  @Param("stunum") long stunum,
                  @Param("coursename") String coursename);

    StudentLeaveList selectleavelistbystunum(@Param("stunum") long stunum, @Param("coursename") String coursename);//查看请假申请列表  2-1

    StudentLeave checkisask(@Param("stunum") long stunum, @Param("coursename") String coursename, @Param("leavetime") Date leavetime);//检查是否已经提交申请

    List<StudentLeave> stuselectAllleave(@Param("classname") String classname,
                                         @Param("stunum") long stunum);//学生查看请假申请


    List<StudentLeave> selectAllleave(@Param("classname") String classname,
                                      @Param("coursename") String coursename);//教师查看请假申请

}
