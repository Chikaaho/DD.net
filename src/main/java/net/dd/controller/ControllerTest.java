package net.dd.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.dd.annotaion.JwtIgnore;

import net.dd.common.Result;
import net.dd.pojo.Audience;
import net.dd.pojo.Student;
import net.dd.service.impl.StudentServiceImpl;
import net.dd.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@CrossOrigin
public class ControllerTest {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private Audience audience;
    @Autowired
    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    @PostMapping("/jwtLogin")
    @JwtIgnore
    @ResponseBody
    public Result adminLogin(HttpServletResponse response, @RequestParam String username, @RequestParam String password) {
        // 这里模拟测试, 默认登录成功，返回用户ID和角色信息
        String userId = UUID.randomUUID().toString();
        String role = "admin";
        // 创建token
        String token = JwtTokenUtil.createJWT(userId, username, role, audience);
        log.info("### 登录成功, token={} ###", token);
        // 将token放在响应头
        response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY, JwtTokenUtil.TOKEN_PREFIX + token);
        // 将token响应给客户端
        JSONObject result = new JSONObject();
        result.put("token", token);
        return Result.succ(result);
    }
    @GetMapping("/jwtUsers")
    @ResponseBody
    public Result userList() {
        log.info("### 查询所有用户列表 ###");
        return Result.succ();
    }

}
