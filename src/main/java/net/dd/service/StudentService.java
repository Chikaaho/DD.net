package net.dd.service;

import net.dd.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {

    // 查询学生信息
    List<Student> selectStudent();

    Student selectStudentByNumber(@Param("usernum") long usernum);

    Student selectStudentByName(@Param("username") String username);

    List<Student> selectStudentByClassName(@Param("classname") String classname);

    // 添加学生信息
    int insertStudent(@Param("username") String username
            , @Param("password") String password
            , @Param("usernum") long usernum
            , @Param("classname") String classname);

    // 修改学生信息
    int updateStudent(@Param("id") long id
            , @Param("username") String username
            , @Param("password") String password
            , @Param("usernum") long usernum
            , @Param("classname") String classname);

    // 删除学生信息(假删除)
    int deleteStudent(@Param("id") long id);

    // 删除学生信息(真删除)
    int dropStudent(@Param("id") long id);

    // 登录验证
    Student studentLoginCheck(@Param("username") String username, @Param("password") String password);

}
