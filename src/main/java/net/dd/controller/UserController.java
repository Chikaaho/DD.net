package net.dd.controller;

import net.dd.pojo.Student;
import net.dd.pojo.Teacher;
import net.dd.service.impl.StudentServiceImpl;
import net.dd.service.impl.TeacherServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    private Model model;

    @RequestMapping("/loginCheck.php")
    @ResponseBody
    @CrossOrigin
    public void teacherLogin(@RequestParam("teacher") Teacher teacher
            , @RequestParam("student") Student student
            , @RequestParam("id") long id
            , Model model) {
        if (!teacherService.selectTeacher(id).contains(teacher)) {
            model.addAttribute("ERROR_MSG", "该用户不存在或账号密码输入错误，请检查后重新输入！");
        }
        if (!studentService.selectStudent(id).contains(student)) {
            model.addAttribute("ERROR_MSG", "该用户不存在或账号密码输入错误，请检查后重新输入！");
        }
    }

    @RequestMapping("/toLogin.php")
    @ResponseBody
    @CrossOrigin
    public String login() {
        return "index";
    }

    @RequestMapping("/regist.php")
    @CrossOrigin
    public String toRegistPage() {

        return "regist/regist";
    }

}
