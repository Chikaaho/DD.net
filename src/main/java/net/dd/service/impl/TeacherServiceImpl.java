package net.dd.service.impl;

import net.dd.mapper.TeacherMapper;
import net.dd.pojo.Teacher;
import net.dd.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> selectTeacher(long id) {
        return teacherMapper.selectTeacher(id);
    }

    @Override
    public int insertTeacher(Teacher teacher) {
        return teacherMapper.insertTeacher(teacher);
    }

    @Override
    public int updateTeacher(long id, Teacher teacher) {
        return teacherMapper.updateTeacher(id, teacher);
    }

    @Override
    public int deleteTeacher(long id) {
        return teacherMapper.deleteTeacher(id);
    }
}
