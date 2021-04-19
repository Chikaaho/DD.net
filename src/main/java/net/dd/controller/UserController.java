package net.dd.controller;

import net.dd.service.impl.StudentServiceImpl;
import net.dd.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {


    private StudentServiceImpl studentService;
    private TeacherServiceImpl teacherService;
    private final HashMap<Object, Object> jsonDataMap = new HashMap<>();
    private int license;

    @Autowired
    public void setStudentServiceImpl(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setTeacherServiceImpl(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping("/login.do")
    public String loginCheck(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        int stu = studentLoginCheck(username, password);
        int teac = teacherLoginCheck(username, password);
        license = stu | teac;
        jsonDataMap.clear();
        if (license == 0) {
            model.addAttribute("LOGIN_ERROR", "");
            return "";
        }
        if (license == 0b0011) {
            session.setAttribute("userLicense", "student");
            jsonDataMap.put("student", studentService.selectStudent());
            return "";
        } else if (license == 0b1100) {
            session.setAttribute("userLicense", "teacher");
            jsonDataMap.put("teacher", teacherService.selectTeacher());
            return "";
        } else if (license == 0b1111) {
            session.setAttribute("userLicense", "admin");
            jsonDataMap.put("teacher", teacherService.selectTeacher());
            jsonDataMap.put("student", studentService.selectStudent());
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

    @RequestMapping("/delete.do")
    public String deleteUser(@RequestParam long id) {
        if (license == 0b0011) {
            studentService.deleteStudent(id);
        } else if (license == 0b1100) {
            teacherService.deleteTeacher(id);
        } else if (license == 0b1111){
            System.out.println();
        }
        return "";
    }

    @RequestMapping("/jsonData")
    @ResponseBody
    public Map<Object, Object> jsonData() {
        jsonDataMap.clear();
        jsonDataMap.put("userLicense", "admin");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("username", "chika");
        map.put("password", "123456z");
        map.put("usernum", 18240000);
        map.put("classname", "soft1");
        jsonDataMap.put("message", map);
        return jsonDataMap;
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
