package net.dd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignPlanDto implements Serializable {
    private int id;
    private String classname;  //班级名
    private int signstate;    //签到表是否激活 0表示未激活 1表示激活
    private long signid;      //签到表id  根据当天的日期定义
    private String coursename; //课程名

}
