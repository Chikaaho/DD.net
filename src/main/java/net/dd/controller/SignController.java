package net.dd.controller;

import net.dd.common.Result;
import net.dd.dto.SignDto;
import net.dd.mapper.StuSignMapper;
import net.dd.pojo.StuSign;
import net.dd.service.StuSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SignController {

    @Autowired
    StuSignService stuSignService;

    @GetMapping("/Signin")  //签到
    public Result StuSignin(@RequestBody SignDto signDto){
        long num = signDto.getStunum();  //学号
        String state = signDto.getState();  //签到的状态
        int a = stuSignService.updateStuSign(num,state);

        return Result.succ(200,"更新签到成功",a);
    }

    @GetMapping("/stustate") //根据学号查询签到
    public Result StuState(@RequestBody SignDto signDto){
        long num = signDto.getStunum();  //谁签
        StuSign stuSign = stuSignService.selectStuSignByNumber(num);
        return Result.succ(stuSign);
    }
    @GetMapping("/Allstustate") //所有签到
    public Result Allstustate(){
        List<StuSign> AllstuSign = stuSignService.selectStuSign();
        return Result.succ(AllstuSign);
    }


}
