package net.dd.mapper;

import io.swagger.models.auth.In;
import net.dd.pojo.HomeWork;
import net.dd.pojo.HomeWorkPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface HomeWorkMapper {
    // 查询布置的作业   用于教师端查看所有布置的作业
    List<HomeWorkPlan> selectHomeWorkPlanByclassandcourse(@Param("coursename") String coursename,
                                                          @Param("classname") String classname);

    // 查询布置的作业详情   用于教师端查看
    List<HomeWork> selectOneHomeWork(@Param("title") String title,
                                     @Param("coursename") String coursename,
                                     @Param("classname") String classname);
    // 查询布置的作业   用于学生端查看所有作业
    List<HomeWork> stuselectAllHomeWork(@Param("stunum") long stunum,
                                  @Param("coursename") String coursename,
                                  @Param("classname") String classname);
    // 查询布置的作业详情   用于学生端查看
    HomeWork stuselectOneHomeWork(@Param("stunum") long stunum,
                                        @Param("title") String title,
                                     @Param("coursename") String coursename,
                                     @Param("classname") String classname);

    // 查询布置的作业   用于学生端查看对应布置的作业
    List<HomeWorkPlan> selectHomeWorkPlanByclassandcourseandid(@Param("id") Integer id, @Param("coursename") String coursename,
                                                               @Param("classname") String classname);

    //发布作业
    int insertHomeWorkPlan(@Param("title") String title,
                           @Param("content") String content,
                           @Param("deadline") Date deadline,
                           @Param("file") String file,
                           @Param("coursename") String coursename,
                           @Param("classname") String classname);

    //教师上传文件
    int teacheruploadfile(
                           @Param("file") String file,
                           @Param("coursename") String coursename,
                           @Param("classname") String classname);

    //发布作业后插入到作业表
    int insertHomeWork(@Param("title") String title,
                       @Param("coursename") String coursename,
                       @Param("classname") String classname,
                       @Param("stunum") long stunum
    );

    int stusubmithomework(@Param("id") Integer id,
                          @Param("answer") String answer,
                          @Param("stufile") String stufile);

    int teacherupdatehomework(@Param("id") Integer id,
                          @Param("score") Integer score);
}
