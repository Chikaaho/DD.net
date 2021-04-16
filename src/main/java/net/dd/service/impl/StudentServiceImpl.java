package net.dd.service.impl;

import net.dd.mapper.StudentMapper;
import net.dd.pojo.Student;
import net.dd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
// @Mapper
public class StudentServiceImpl implements StudentService {

    private StudentMapper studentMapper;

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> selectStudent() {
        return studentMapper.selectStudent();
    }

    @Override
    public Student selectStudentByNumber(long usernum) {
        return studentMapper.selectStudentByNumber(usernum);
    }

    @Override
    public Student selectStudentByName(String username) {
        return studentMapper.selectStudentByName(username);
    }

    @Override
    public Student selectStudentByClassName(String classname) {
        return studentMapper.selectStudentByClassName(classname);
    }

    @Override
    public int insertStudent(String username, String password, long usernum, String classname) {
        Student student = studentMapper.selectStudentByNumber(usernum);
        if (student == null) {
            return studentMapper.insertStudent(username, password, usernum, classname);
        }
        if (student.getIsDeleted() == 1) {
            return 1 << 3;
        } else {
            return 0;
        }
    }


    @Override
    public int updateStudent(long id, Student student) {
        return studentMapper.updateStudent(id, student);
    }

    @Override
    public int deleteStudent(long id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    public int dropStudent(long id) {
        return studentMapper.dropStudent(id);
    }

    @Override
    public Student studentLoginCheck(String username, String password) {
        return studentMapper.studentLoginCheck(username, password);
    }
}
