package net.dd.controller;

import net.dd.pojo.Student;
import net.dd.pojo.Teacher;
import net.dd.service.StudentService;
import net.dd.service.TeacherService;
import net.dd.service.impl.StudentServiceImpl;
import net.dd.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {


    private StudentServiceImpl studentService;
    private TeacherServiceImpl teacherService;

    @Autowired
    public void setStudentServiceImpl(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setTeacherServiceImpl(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping("/loginCheck")
    @ResponseBody
    public String loginCheck(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        int stu = studentLoginCheck(username, password);
        int teac = teacherLoginCheck(username, password);
        int license = stu | teac;
        if (username.equals("admin") && password.equals("admin@1234")) {
            session.setAttribute("userLicense", "admin");
            return "";
        }
        if (license == 0) {
            model.addAttribute("LOGIN_ERROR", "");
            return "";
        }
        if (license == 0b0011) {
            session.setAttribute("userLicense", "student");
            return "";
        } else if (license == 0b1100) {
            session.setAttribute("userLicense", "teacher");
            return "";
        }
        return "";
    }

    public int studentLoginCheck(String username, String password) {
        return studentService.studentLoginCheck(username, password) == null ? 0 : 0b0011;
    }

    public int teacherLoginCheck(String username, String password) {
        return teacherService.teacherLoginCheck(username, password) == null ? 0 : 0b1100;
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
