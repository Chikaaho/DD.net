package net.dd.pojo;

import java.io.Serializable;

/**
 * @author Chika
 * @program DDNet
 * @create 2021/5/24 - 14:45
 **/
public class StudentLeave implements Serializable {

    private Long leaveId;
    private Long studentId;
    private String stuName;
    private Integer leaveState;
    private String leaveReason;

    public StudentLeave(Long leaveId, Long studentId, String stuName, Integer leaveState, String leaveReason) {
        this.leaveId = leaveId;
        this.studentId = studentId;
        this.stuName = stuName;
        this.leaveState = leaveState;
        this.leaveReason = leaveReason;
    }

    public Long getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Long leaveId) {
        this.leaveId = leaveId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getLeaveState() {
        return leaveState;
    }

    public void setLeaveState(Integer leaveState) {
        this.leaveState = leaveState;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }
}
