package net.dd.controller;

import net.dd.pojo.Student;
import net.dd.pojo.Teacher;
import net.dd.service.StudentService;
import net.dd.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {


    private StudentService studentService;
    private TeacherService teacherService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping("/loginCheck")
    public String loginCheck(@RequestParam long id
            , @RequestParam String username
            , @RequestParam String password) {
        return (id & 1) == 0b0001 ? studentLoginCheck(username, password) : teacherLoginCheck(username, password);
    }

    public String studentLoginCheck(@RequestParam String username
            , @RequestParam String password) {

        return "";
    }

    public String teacherLoginCheck(@RequestParam String username
            , @RequestParam String password) {
        return "";
    }

    @RequestMapping("/toLogin")
    public String login() {
        return "index";
    }

    @RequestMapping("/regist")
    public String toRegistPage() {
        return "regist/regist";
    }

}
