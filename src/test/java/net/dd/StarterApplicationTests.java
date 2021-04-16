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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootTest
@MapperScan("net.dd.mapper")
class StarterApplicationTests {

    @Autowired
    StudentMapper mapper;

    @Autowired
    TeacherServiceImpl service;

    @Autowired
    StudentServiceImpl studentService;

    @Test
    void contextLoads() {
        studentService.insertStudent("chika", "1234", 18240398, "soft1");
        System.out.println(studentService.studentLoginCheck("chika", "1234"));
        System.out.println(studentService.selectStudent().toString());
        studentService.deleteStudent(3);
        System.out.println(studentService.selectStudentByNumber(18240398));
        int i = studentService.insertStudent("dd", "dd", 18240398, "ss");
        if (i == 0) {
            System.out.println("不存在");
        }
        if (i == 1 << 3) {
            System.out.println("已注销");
        }
        System.out.println(i);
    }

}
