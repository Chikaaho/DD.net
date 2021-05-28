package net.dd.controller;

import net.dd.common.Result;
import net.dd.dto.StudentLeaveDto;
import net.dd.enums.ApiEnum;
import net.dd.mapper.StudentLeaveMapper;
import net.dd.mapper.StudentMapper;
import net.dd.pojo.StudentLeave;
import net.dd.service.StudentLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Chika
 * @program DDNet
 * @create 2021/5/24 - 14:37
 **/
@RestController
@CrossOrigin
public class AskForLeaveController {
    @Autowired
    StudentLeaveMapper studentLeaveMapper;

    private StudentLeaveService studentLeaveService;

    @Autowired
    public void setStudentLeaveService(StudentLeaveService studentLeaveService) {
        this.studentLeaveService = studentLeaveService;
    }

    // 请假流程
    // 发起请假
    @PostMapping("/askForLeave")
    public Result askForLeave(@RequestBody StudentLeaveDto studentLeaveDto) {
        StudentLeave studentLeave = studentLeaveMapper.checkisask(studentLeaveDto.getStunum(),
                studentLeaveDto.getCoursename(),studentLeaveDto.getLeavetime());  //检查是否已申请过
        if(studentLeave != null) return Result.fail("已经申请过了！");
        int ask = studentLeaveMapper.start(studentLeaveDto.getStunum(),  //1-1
                studentLeaveDto.getStuname(),
                studentLeaveDto.getClassname(),
                studentLeaveDto.getCoursename(),
                studentLeaveDto.getLeavereason(),
                studentLeaveDto.getLeavetime());
        if (ask == 0) return Result.fail("申请失败");
        int leaveid = studentLeaveMapper.leaveid();
        int leavelist = studentLeaveMapper.leavelist(leaveid, studentLeaveDto.getStunum(), studentLeaveDto.getCoursename());
        if (leavelist == 0) return Result.fail("申请失败");
        else return Result.succ("申请成功");
    }

    //学生查看申请
    @PostMapping("/stugetaskleave")
    public Result stugetaskleave(@RequestBody StudentLeaveDto studentLeaveDto) {
        List<StudentLeave> studentLeaves = studentLeaveMapper.stuselectAllleave(studentLeaveDto.getClassname(),studentLeaveDto.getStunum());
        if(studentLeaves.size() == 0) return Result.fail("没有申请信息！");
        return Result.succ(200,"获取请假申请成功",studentLeaves);
    }

    //教师查看申请表
    @PostMapping("/teachercheckleavelist")
    public Result teachercheckleavelist(@RequestBody StudentLeaveDto studentLeaveDto) {
        List<StudentLeave> studentLeaves = studentLeaveMapper.selectAllleave(studentLeaveDto.getClassname(),studentLeaveDto.getCoursename());
        if(studentLeaves.size() == 0) return Result.fail("当前没有申请请假的学生");
        return Result.succ(200,"获取请假的学生成功",studentLeaves);
    }

    // 老师处理
    //通过
    @PostMapping("/accept")
    public Result accept(@RequestBody StudentLeaveDto studentLeaveDto) {
       int accept = studentLeaveMapper.acceptleave(studentLeaveDto.getLeaveId());
       if(accept == 0) return Result.fail("通过失败");
       else return Result.succ("通过成功");
    }

    //驳回
    @PostMapping("/reject")
    public Result reject(@RequestBody StudentLeaveDto studentLeaveDto) {
        int reject = studentLeaveMapper.rejectleave(studentLeaveDto.getLeaveId());
        if(reject == 0) return Result.fail("驳回失败");
        else return Result.succ("驳回成功");
    }

}