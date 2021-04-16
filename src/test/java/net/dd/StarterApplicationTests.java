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
        int i = studentService.insertStudent("test", "zzz123", 18240398, "demo1");
        if (i == 0) {
            System.out.println("已存在");
        }
        studentService.deleteStudent(5);
        String str = "0398";
        long num = Long.parseLong(str);
        System.out.println(studentService.selectStudentByNumber(num));
    }

}
