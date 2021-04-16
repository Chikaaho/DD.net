package net.dd.controller;

import net.dd.pojo.Student;
import net.dd.service.impl.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;



public class ControllerTest {


    private StudentServiceImpl studentService;

    public Student getJson() {
        List<Student> students = studentService.selectStudent();
        return students.get(0);
    }

}
