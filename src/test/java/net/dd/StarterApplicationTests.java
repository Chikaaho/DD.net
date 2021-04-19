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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
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
    JavaMailSenderImpl javaMailSender;
    @Autowired(required = false)
    public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("今晚开会");
        message.setText("大家，好！今晚7:30在教学楼201开班委会，请各位班委准时参加！谢谢！");
        message.setTo("1609879250@qq.com");
        message.setFrom("chikaho@foxmail.com");
    }

    @Test
    public void test2() throws Exception{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("今晚开会");
        helper.setText("大家，好！<br> &nbsp;&nbsp;<b style='color:red'>今晚7:30在教学楼201开班委会，请各位班委准时参加！</b> <br>谢谢！",true);
        helper.setTo("1609879250@qq.com");
        helper.setFrom("chikaho@foxmail.com");

        //添加附件
//        helper.addAttachment("会议说明.txt",new File("C:\\Users\\Dylan\\Pictures\\会议说明.txt"));
//        helper.addAttachment("会议图片.jpg",new File("C:\\Users\\Dylan\\Pictures\\会议图片.jpg"));

        javaMailSender.send(mimeMessage);
    }

}
