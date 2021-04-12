package net.dd.controller;

import net.dd.pojo.Student;
import net.dd.service.impl.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class ControllerTest {

    @Resource
    private StudentServiceImpl studentService;

    @RequestMapping("/test")
    @ResponseBody
    @CrossOrigin
    public Student getJson() {
        List<Student> students = studentService.selectStudent(1);
        return students.get(0);
    }

}
