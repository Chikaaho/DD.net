package net.dd.controller;

import io.swagger.annotations.ApiModelProperty;
import net.dd.pojo.Student;
import net.dd.pojo.Teacher;
import net.dd.service.StudentService;
import net.dd.service.TeacherService;
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


    private StudentService studentService;
    private TeacherService teacherService;
    private static final HashMap<Object, Object> JSON_DATA_MAP = new HashMap<>();
    // 登录凭证
    private static int LICENSE = 0;

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
        LICENSE = stu | teac;
        JSON_DATA_MAP.clear();
        if (LICENSE == 0) {
            model.addAttribute("LOGIN_ERROR", "");
            return "/login";
        }
        if (LICENSE == 0b0011) {
            session.setAttribute("userLicense", "student");
            JSON_DATA_MAP.put("student", studentService.selectStudent());
            return "sys/index";
        } else if (LICENSE == 0b1100) {
            session.setAttribute("userLicense", "teacher");
            JSON_DATA_MAP.put("teacher", teacherService.selectTeacher());
            return "sys/index";
        } else if (LICENSE == 0b1111) {
            session.setAttribute("userLicense", "admin");
            JSON_DATA_MAP.put("teacher", teacherService.selectTeacher());
            JSON_DATA_MAP.put("student", studentService.selectStudent());
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
    @ApiModelProperty(value = "注册教师")
    public String registUser(@RequestParam String username, @RequestParam String password, @RequestParam String email, Model model) {
        String activeCodes = IDUtil.getUUID();
        int i = teacherService.registTeacher(username, password, activeCodes, email);
        if (i == 1 << 3) {
            model.addAttribute("REGIST_ERROR", "该账号信息已存在,请直接登录");
            return "index";
        } else {
            model.addAttribute("REGIST_MESSAGE", "注册信息已提交,请前往邮箱查看");
            return "index";
        }
    }

    @RequestMapping("/add.do")
    @ApiModelProperty(value = "添加学生")
    public String addUser(@RequestParam String username, @RequestParam String password, @RequestParam String classname, @RequestParam long usernum, Model model) {
        if (LICENSE != 0b1100 && LICENSE != 0b1111) {
            model.addAttribute("","");
            return "";
        }
        int i = studentService.insertStudent(username, password, usernum, classname);
        if (i == 1 << 3) {
            return "index";
        } else {
            model.addAttribute("STUDENT_REPEAT_ERROR", "");
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
        if (LICENSE == 0b0011) {
            studentService.deleteStudent(id);
        } else if (LICENSE == 0b1100) {
            teacherService.deleteTeacher(id);
        } else if (LICENSE == 0b1111) {
            System.out.println();
        }
        return "";
    }

    @PostMapping("waring/drop.do")
    public String dropUser(@RequestParam long id, Model model) {
        if (LICENSE == 0b0011) {
            model.addAttribute("ERROR", "您的权限不足");
            return "index";
        } else {
            studentService.dropStudent(id);
            return "index";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        LICENSE = 0;
        session.invalidate();
        session.removeAttribute("userLicense");
        return "index";
    }


    /**
     * @return 数据查询
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
        JSON_DATA_MAP.clear();

        return JSON_DATA_MAP;
    }

    /**
     * @return 页面跳转
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
