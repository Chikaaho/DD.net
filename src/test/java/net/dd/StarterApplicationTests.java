package net.dd;

import net.dd.mapper.StudentMapper;
import net.dd.mapper.TeacherMapper;
import net.dd.service.impl.StudentServiceImpl;
import net.dd.service.impl.TeacherServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@MapperScan("net.dd.mapper")
class StarterApplicationTests {

    @Autowired
    StudentMapper mapper;

    @Autowired
    TeacherServiceImpl service;

    @Autowired
    StudentServiceImpl studentService;

    int license;
    Map<Object, Object> jsonDataMap = new HashMap<>();

    @Test
    void contextLoads() {
        System.out.println(loginCheck("testDelete", "1234"));
    }

    public String loginCheck(@RequestParam String username, @RequestParam String password) {
        int stu = studentLoginCheck(username, password);
        int teac = teacherLoginCheck(username, password);
        license = stu | teac;
        jsonDataMap.clear();
        if (license == 0) {
           // model.addAttribute("LOGIN_ERROR", "");
            return "登录失败";
        }
        if (license == 0b0011) {
            //session.setAttribute("userLicense", "student");
            jsonDataMap.put("student", studentService.selectStudent());
            return "是学生";
        } else if (license == 0b1100) {
            //session.setAttribute("userLicense", "teacher");
            jsonDataMap.put("teacher", service.selectTeacher());
            return "是教师";
        } else if (license == 0b1111) {
            //session.setAttribute("userLicense", "admin");
            jsonDataMap.put("teacher", service.selectTeacher());
            jsonDataMap.put("student", studentService.selectStudent());
            return "是管理员";
        }
        return "未登录";
    }

    public int studentLoginCheck(String username, String password) {
        return studentService.studentLoginCheck(username, password) == null ? 0 : 0b0011;
    }

    public int teacherLoginCheck(String username, String password) {
        return service.teacherLoginCheck(username, password) == null ? 0 : 0b1100;
    }

}
