package net.dd.service.impl;

import net.dd.mapper.StudentMapper;
import net.dd.pojo.Student;
import net.dd.service.StudentService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
// @Mapper
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectStudent(long id) {
        return studentMapper.selectStudent(id);
    }

    @Override
    public int insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    @Override
    public int updateStudent(long id, Student student) {
        return studentMapper.updateStudent(id, student);
    }

    @Override
    public int deleteStudent(long id) {
        return studentMapper.deleteStudent(id);
    }
}
