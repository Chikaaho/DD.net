package net.dd.service.impl;

import net.dd.mapper.StudentMapper;
import net.dd.pojo.Student;
import net.dd.service.StudentService;
import net.dd.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
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
        Student student = studentMapper.selectStudentByNumber(usernum);
        return student.getIsDeleted() == 1 ? null : student;
    }

    @Override
    public Student selectStudentByName(String username) {
        Student student = studentMapper.selectStudentByName(username.replaceAll("\\s*", ""));
        if(student==null) return null;  //登录错误验证
        return student.getIsDeleted() == 1 ? null : student;
    }

    @Override
    public Student selectStudentByClassName(String classname) {
        Student student = studentMapper.selectStudentByClassName(classname.replaceAll("\\s*", ""));
        return student.getIsDeleted() == 1 ? null : student;
    }

    @Override
    public int insertStudent(String username, String password, long usernum, String classname) {
        Student student = studentMapper.selectStudentByNumber(usernum);
        if (student == null) {
            return studentMapper.insertStudent(username.replaceAll("\\s*", "")
                    , MD5Util.encode(password.replaceAll("\\s*", ""))
                    , usernum
                    , classname.replaceAll("\\s*", ""));
        }
        if (student.getIsDeleted() == 1) {
            return 1 << 3;
        } else {
            return 0;
        }
    }

    @Override
    public int updateStudent(long id, String username, String password, long usernum, String classname) {
        return studentMapper.updateStudent(id
                , username.replaceAll("\\s*", "")
                , MD5Util.encode(password.replaceAll("\\s*", ""))
                , usernum
                , classname.replaceAll("\\s*", ""));
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
        Student student = studentMapper.studentLoginCheck(username.replaceAll("\\s*", "")
                , MD5Util.encode(password.replaceAll("\\s*", "")));
        if (student == null || student.getIsDeleted() == 1) {
            return null;
        }
        return student;
    }
}
