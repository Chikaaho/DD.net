package net.dd.controller;

import net.dd.enums.ApiEnum;
import net.dd.pojo.StudentLeave;
import net.dd.service.StudentLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chika
 * @program DDNet
 * @create 2021/5/24 - 14:37
 **/
@RestController
@CrossOrigin
public class AskForLeaveController {

    private StudentLeaveService studentLeaveService;

    @Autowired
    public void setStudentLeaveService(StudentLeaveService studentLeaveService) {
        this.studentLeaveService = studentLeaveService;
    }

    // 请假流程
    // 发起请假
    @PostMapping("/askForLeave")
    public ApiEnum askForLeave(@RequestParam Long studentId, @RequestParam String stuName, @RequestParam String leaveReason) {
        try {
            studentLeaveService.start(studentId, stuName, leaveReason);
        } catch (Exception e) {
            return ApiEnum.FAILED;
        }
        return ApiEnum.SUCCESS;
    }

    // 老师处理
    @PostMapping("/approve")
    public ApiEnum approve(@RequestParam Integer leaveState, @RequestParam Long studentId) {
        try {
            studentLeaveService.approve(leaveState);
            if (!leaveState.equals(1)) {
                StudentLeave studentLeave = studentLeaveService.selectByStudentId(studentId);
                this.end(studentLeave.getLeaveId());
                return ApiEnum.FAILED;
            }
        } catch (Exception e) {
            return ApiEnum.FAILED;
        }
        return ApiEnum.SUCCESS;
    }

    // 结束
    @PostMapping("/end")
    public void end(@RequestParam Long leaveId) {
        studentLeaveService.end(leaveId);
    }

}
