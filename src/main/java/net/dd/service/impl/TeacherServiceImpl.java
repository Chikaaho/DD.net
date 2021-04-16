package net.dd.service.impl;

import net.dd.mapper.TeacherMapper;
import net.dd.pojo.Teacher;
import net.dd.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherMapper teacherMapper;
    @Autowired
    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public List<Teacher> selectTeacher() {
        return teacherMapper.selectTeacher();
    }

    @Override
    public int insertTeacher(String username,  String password) {
        return teacherMapper.insertTeacher(username.replaceAll("\\s*", ""), password.replaceAll("\\s*", ""));
    }

    @Override
    public int updateTeacher(long id, String username, String password) {
        return teacherMapper.updateTeacher(id, username.replaceAll("\\s*", ""), password.replaceAll("\\s*", ""));
    }

    @Override
    public int deleteTeacher(long id) {
        return teacherMapper.deleteTeacher(id);
    }

    @Override
    public Teacher teacherLoginCheck(String username, String password) {
        Teacher teacher = teacherMapper.teacherLoginCheck(username.replaceAll("\\s*", ""), password.replaceAll("\\s*", ""));
        if (teacher == null) {
            return null;
        }
        if (teacher.getIsDeleted() == 1) {
            return null;
        }
        return teacher;
    }
}
