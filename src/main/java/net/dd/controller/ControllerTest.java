package net.dd.controller;

import net.dd.pojo.Student;
import net.dd.service.impl.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class ControllerTest {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

}
