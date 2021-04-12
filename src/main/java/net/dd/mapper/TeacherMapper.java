package net.dd.mapper;

import net.dd.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {

    // 查询老师信息
    List<Teacher> selectTeacher(@Param("id") long id);

    // 添加老师信息
    int insertTeacher(@Param("teacher") Teacher teacher);

    // 修改老师信息
    int updateTeacher(@Param("id") long id, @Param("teacher") Teacher teacher);

    // 删除老师信息(假删除)
    int deleteTeacher(@Param("id") long id);

}
