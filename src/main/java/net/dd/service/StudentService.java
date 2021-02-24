package net.dd.service;

import net.dd.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {

    // 查询学生信息
    List<Student> selectStudent(@Param("id") long id);

    // 添加学生信息
    int insertStudent(@Param("student") Student student);

    // 修改学生信息
    int updateStudent(@Param("id") long id, @Param("student") Student student);

    // 删除学生信息(假删除)
    int deleteStudent(@Param("id") long id);

}
