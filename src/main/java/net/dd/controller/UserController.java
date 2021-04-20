package net.dd.controller;

import net.dd.pojo.Student;
import net.dd.pojo.Teacher;
import net.dd.service.impl.StudentServiceImpl;
import net.dd.service.impl.TeacherServiceImpl;
import net.dd.utils.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {


    private StudentServiceImpl studentService;
    private TeacherServiceImpl teacherService;
    private final HashMap<Object, Object> jsonDataMap = new HashMap<>();
    // 登录凭证
    private int license;

    @Autowired
    public void setStudentServiceImpl(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setTeacherServiceImpl(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/login.do")
    public String loginCheck(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        int stu = studentLoginCheck(username, password);
        int teac = teacherLoginCheck(username, password);
        license = stu | teac;
        jsonDataMap.clear();
        if (license == 0) {
            model.addAttribute("LOGIN_ERROR", "");
            return "/login";
        }
        if (license == 0b0011) {
            session.setAttribute("userLicense", "student");
            jsonDataMap.put("student", studentService.selectStudent());
            return "sys/index";
        } else if (license == 0b1100) {
            session.setAttribute("userLicense", "teacher");
            jsonDataMap.put("teacher", teacherService.selectTeacher());
            return "sys/index";
        } else if (license == 0b1111) {
            session.setAttribute("userLicense", "admin");
            jsonDataMap.put("teacher", teacherService.selectTeacher());
            jsonDataMap.put("student", studentService.selectStudent());
            return "sys/index";
        }
        return "/login";
    }

    public int studentLoginCheck(String username, String password) {
        return studentService.studentLoginCheck(username, password) == null ? 0 : 0b0011;
    }

    public int teacherLoginCheck(String username, String password) {
        return teacherService.teacherLoginCheck(username, password) == null ? 0 : 0b1100;
    }

    @RequestMapping("/regist.do")
    public String registUser(@RequestParam String username, @RequestParam String password, @RequestParam String email, Model model) {
        String activeCodes = IDUtil.getUUID();
        int i = teacherService.registTeacher(username, password, activeCodes, email);
        if (i == 0) {
            model.addAttribute("REGIST_ERROR", "该账号信息已存在,请直接登录");
            return "index";
        } else {
            model.addAttribute("REGIST_MESSAGE", "注册信息已提交,请前往邮箱查看");
            return "index";
        }
    }

    @RequestMapping("/checkCode")
    public String checkCode(String code) {
        System.out.println("url激活码=>" + code);
        Teacher teacher = teacherService.registCheck(code);
        if (teacher != null) {
            teacherService.modify(1, teacher.getActiveCodes());
            return "success";
        }
        return "failed";
    }

    @PostMapping("/delete.do")
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

    @PostMapping("waring/drop.do")
    public String dropUser(@RequestParam long id, Model model){
        if (license == 0b0011) {
            model.addAttribute("ERROR", "您的权限不足");
            return "index";
        } else {
            studentService.dropStudent(id);
            return "index";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        session.removeAttribute("userLicense");
        return "index";
    }


    /**
    *   @return 数据查询
    **/
    @RequestMapping("/selectAll")
    @ResponseBody
    public List selectAll() {
        List<Student> students = studentService.selectStudent();
        List<Teacher> teachers = teacherService.selectTeacher();
        if (teachers == null) {
            return students;
        } else {
            return teachers;
        }
    }

    @RequestMapping("/jsonData")
    @ResponseBody
    public Map<Object, Object> jsonData() {
        HashMap<Object, Object> map = new HashMap<>();
        jsonDataMap.clear();

        return jsonDataMap;
    }

    /**
    *    @return 页面跳转
    **/
    @RequestMapping("/toLogin")
    public String login() {
        return "sys/login";
    }

    @RequestMapping("/regist")
    public String toRegistPage() {
        return "sys/user/register";
    }

}
