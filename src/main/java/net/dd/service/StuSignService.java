package net.dd.service;

import net.dd.pojo.SignPlan;
import net.dd.pojo.StuSign;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StuSignService {
    // 查询签到信息
    List<StuSign> selectStuSign();

    List<StuSign> selectStuSignBySignId(@Param("signid") long signid,
                                        @Param("classname") String classname,
                                        @Param("coursename") String coursename);

    List<SignPlan> selectStuSignPlanBysignstate(@Param("signid") long signid,
                                           @Param("classname") String classname,
                                           @Param("signstate") long signstate);

    List<StuSign> selectStuSignByNumber(@Param("stunum") long stunum,
                                        @Param("coursename") String coursename);

    StuSign selectONEStuSign(@Param("stunum") long stunum,
                             @Param("signid") long signid,
                             @Param("coursename") String coursename);
    //开启/关闭签到状态
    int updatesignplan(@Param("signid") long signid,
                       @Param("signstate") long signstate,
                       @Param("classname") String classname,
                       @Param("coursename") String coursename
    );

    // 点击签到
    int updateStuSign(@Param("stunum") long stunum,
                      @Param("signid") long signid ,
                      @Param("coursename") String coursename);

    //教师帮签
    int teaupdatasign(@Param("stunum") long stunum,
                      @Param("signid") long signid ,
                      @Param("stusignstate") String stusignstate);

    List<SignPlan> selectOneSignPlan(@Param("signid") long signid,
                               @Param("classname") String classname,
                               @Param("coursename") String coursename);
    //插入签到计划表
    int insertSignPlan( @Param("classname") String classname
            , @Param("signstate") int signstate
            , @Param("signid") long signid
            , @Param("coursename") String coursename
    );
    //插入数据到签到表
    int insertStuSign(@Param("stunum") long stunum
            , @Param("stuname") String stuname
            , @Param("signid") long signid
            , @Param("stusignstate") String stusignstate
            , @Param("coursename") String coursename
            , @Param("classname") String classname);

}
