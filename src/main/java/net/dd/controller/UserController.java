package net.dd.controller;

import net.dd.pojo.Student;
import net.dd.pojo.Teacher;
import net.dd.service.impl.StudentServiceImpl;
import net.dd.service.impl.TeacherServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private StudentServiceImpl studentService;
    @Resource
    private TeacherServiceImpl teacherService;

    private Student student;
    private Teacher teacher;

    @RequestMapping("/loginCheck.php")
    @ResponseBody
    public void teacherLogin(@RequestParam("teacher") Teacher teacher, Model model) {

    }

    @RequestMapping("/login.php")
    @ResponseBody
    public String login() {

        return "html/index";
    }

}
