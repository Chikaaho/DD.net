package net.dd.service;

import net.dd.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherService {

    // 查询老师信息
    List<Teacher> selectTeacher();

    // 添加老师信息
    int insertTeacher(@Param("username") String username, @Param("password") String password);

    // 修改老师信息
    int updateTeacher(@Param("id") long id, @Param("username") String username, @Param("password") String password);

    // 删除老师信息(假删除)
    int deleteTeacher(@Param("id") long id);

    // 登录验证
    Teacher teacherLoginCheck(@Param("username") String username, @Param("password") String password);

}
