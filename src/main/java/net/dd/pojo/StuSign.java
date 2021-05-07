package net.dd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
//学生签到表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuSign implements Serializable {
    //学生签到编号
    private Integer id;
    //学号
    private long stunum;
    //签到安排编号
    private long signid;
    //学生签到状态
    private String stusignstate;

}
