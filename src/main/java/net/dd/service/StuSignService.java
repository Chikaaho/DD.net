package net.dd.service;

import net.dd.pojo.StuSign;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StuSignService {
    // 查询签到信息
    List<StuSign> selectStuSign();

    StuSign selectStuSignByNumber(@Param("stunum") long stunum);

    // 修改签到信息
    int updateStuSign(@Param("stunum") long stunum
            ,@Param("signid") String signid);

}
