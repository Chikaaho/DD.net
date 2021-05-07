package net.dd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//签到安排表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignPlan implements Serializable {

    //签到安排编号
    private long id;
    //课程编号
    private long classid;
    //签到状态
    private String signstate;
    //删除状态
    private int isdeleted;
}
