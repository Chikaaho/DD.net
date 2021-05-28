package net.dd.controller;

import io.swagger.annotations.ApiModelProperty;
import net.dd.common.Result;
import net.dd.dto.RegistDto;
import net.dd.enums.ApiEnum;
import net.dd.pojo.Student;
import net.dd.pojo.Teacher;
import net.dd.service.StudentService;
import net.dd.service.TeacherService;
import net.dd.service.impl.StudentServiceImpl;
import net.dd.service.impl.TeacherServiceImpl;
import net.dd.utils.IDUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {


    private StudentService studentService;
    private TeacherService teacherService;
    private static final HashMap<Object, Object> JSON_DATA_MAP = new HashMap<>();
    /*
     * {
     *   STATUS: 488
     *   MESSAGE: "该账号已注册"
     *   DATA: "LOGIN_ERROR"
     * }
     * */
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
    @Deprecated
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

    @Deprecated
    public int studentLoginCheck(String username, String password) {
        return studentService.studentLoginCheck(username, password) == null ? 0 : 0b0011;
    }

    @Deprecated
    public int teacherLoginCheck(String username, String password) {
        return teacherService.teacherLoginCheck(username, password) == null ? 0 : 0b1100;
    }

    @RequestMapping("/regist.do")
    @ApiModelProperty(value = "注册教师")
    public Result registUser(@RequestBody RegistDto registDto) {
        String activeCodes = IDUtil.getUUID();
        int i = teacherService.registTeacher(registDto.getUsername(),
                registDto.getPassword(),
                activeCodes,
                registDto.getEmail(),
                registDto.getTeacherNum());
        if (i == 1 << 3) {
            return Result.fail("注册失败");
        } else {
            return Result.succ("注册成功");
        }
    }

    @RequestMapping("/checkCode")
    public String checkCode(String code) {
        System.out.println("url激活码=>" + code);
        Teacher teacher = teacherService.registCheck(code);
        if (teacher != null) {
            teacherService.modify(1, teacher.getActiveCodes());
            return "验证成功";
        }
        return "验证失败";
    }

    @RequestMapping("/add.do")
    @ApiModelProperty(value = "添加学生")
    public ApiEnum addUser(@RequestParam String username, @RequestParam String password,
                           @RequestParam String classname, @RequestParam long usernum) {
        if (LICENSE != 0b1100 && LICENSE != 0b1111) {
            return ApiEnum.USER_NOT_LEAGLE;
        }
        int i = studentService.insertStudent(username, password, usernum, classname);
        if (i == 1 << 3) {
            return ApiEnum.SUCCESS;
        } else {
            return ApiEnum.FAILED;
        }
    }


    @PostMapping("/delete.do")
    public ApiEnum deleteUser(@RequestParam long id) {
        if (LICENSE == 0b0011) {
            studentService.deleteStudent(id);
        } else if (LICENSE == 0b1100) {
            teacherService.deleteTeacher(id);
        } else if (LICENSE == 0b1111) {
            System.out.println();
        }
        return ApiEnum.SUCCESS;
    }

    @PostMapping("waring/drop.do")
    public void dropUser(@RequestParam long id) {
        studentService.dropStudent(id);
    }

    @RequestMapping("/logout")
    @Deprecated
    public void logout(HttpSession session) {
        LICENSE = 0;
        session.invalidate();
        session.removeAttribute("userLicense");
    }


    /**
     * @return 数据查询
     **/
    @RequestMapping("/selectAll")
    @ResponseBody
    public List selectAll() {
        List<Teacher> teachers = teacherService.selectTeacher();
        List<Student> students = studentService.selectStudent();
        if (LICENSE == 0b1111) {
            List<List> list = new ArrayList<>();
            list.add(teachers);
            list.add(students);
            return list;
        } else if (LICENSE == 0b1100) {
            return students;
        }
        return null;
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
    @Deprecated
    public String login() {
        return "sys/login";
    }

    @RequestMapping("/regist")
    @Deprecated
    public String toRegistPage() {
        return "sys/user/register";
    }

}
