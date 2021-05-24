package net.dd.controller;

import net.dd.common.Result;
import net.dd.dto.LoginDto;
import net.dd.mapper.StudentMapper;
import net.dd.pojo.Student;
import net.dd.service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin //所有域名均可访问该类下所有接口
//@CrossOrigin("http://localhost:8081") // 只有指定域名可以访问该类下所有接口
public class ShiroController {
    @Autowired
    StudentService studentService;


    @PostMapping("/stulogin")   //学生登录接口
    public Result login(@RequestBody LoginDto loginDto){
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();
        String role = loginDto.getRole();
        System.out.println("=========================");
        System.out.println("username+password+role:"+username+"======="+password+"====="+role);


        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password,role);
        //账号密码令s,
        // AuthenticationToken token = new UsernamePasswordToken(username, password);
        System.out.printf("token:"+token.getPrincipal());
        //获得当前用户到登录对象，现在状态为未认证
        Subject subject = SecurityUtils.getSubject();

        try{
            subject.login(token); //执行登录方法，如果没有异常就说明ok了
            Subject currentSubject = SecurityUtils.getSubject();
            Object user = (Object) currentSubject.getPrincipal();
            System.out.println("这里是登录并验证成功的信息"+user);
            return Result.succ(200,"登录操作成功",user);
        }catch (UnknownAccountException e){//用户名不存在
            //model.addAttribute("msg","用户名错误");
            return Result.fail("用户名不存在");
            //return "sys/login";
        }catch (IncorrectCredentialsException e){//密码不存在
            //model.addAttribute("msg","密码错误");
            return Result.fail("密码错误");
            //return "sys/login";
        }
    }
    @RequestMapping("/noauth")
    @ResponseBody
    public String unauthorized(){
        return "未授权";
    }
}
