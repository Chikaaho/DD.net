package net.dd.mapper;

import net.dd.pojo.Admin;
import net.dd.pojo.Banji;
import net.dd.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface AdminMapper {

    // 查询管理员信息
    List<Admin> selectAdmin();

    Admin selectAdminByNumber(@Param("adminnum") long adminnum);

    int insertAdmin(@Param("adminnum") long adminnum,@Param("username") String username,@Param("password") String password);

    //查询班级信息
    List<Banji> selectBanji();
    //查询班级人数
    int selectBanjimember(@Param("classname") String classname);
    //查询课程信息
    List<Course> selectCourse();

    //添加课程
    int insertCourse(@Param("coursename") String coursename, @Param("starttime") Date starttime, @Param("endtime") Date endtime, @Param("classesname") String classesname, @Param("teachernum") Integer teachernum);
    //修改课程
    int updateCourse(@Param("courseid") Integer courseid, @Param("coursename") String coursename, @Param("starttime") Date starttime, @Param("endtime") Date endtime, @Param("classesname") String classesname, @Param("teachernum") Integer teachernum);
    //删除课程
    int deleteCourse(@Param("courseid") Integer courseid);

    //添加班级
    int insertBanji(@Param("classname") String classname, @Param("major") String major);
    //修改班级
    int updateBanji(@Param("classesid") Integer classesid, @Param("classname") String classname, @Param("major") String major);
    //删除班级
    int deleteBanji(@Param("classesid") Integer classesid);

}
