package net.dd.controller;

import net.dd.common.Result;
import net.dd.dto.SignDto;
import net.dd.dto.SignPlanDto;
import net.dd.dto.SomeSignDto;
import net.dd.mapper.StuSignMapper;
import net.dd.pojo.SignPlan;
import net.dd.pojo.StuSign;
import net.dd.pojo.Student;
import net.dd.service.StuSignService;
import net.dd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin //所有域名均可访问该类下所有接口
//@CrossOrigin("http://localhost:8081") // 只有指定域名可以访问该类下所有接口
public class SignController {

    @Autowired
    StuSignService stuSignService;
    @Autowired
    StudentService studentService;
    @Autowired
    StuSignMapper stuSignMapper;

    @PostMapping("/Signin")  //签到
    public Result StuSignin(@RequestBody SignDto signDto){
        long num = signDto.getStunum();  //学号
        long signid = signDto.getSignid(); //签到表编号
        String state = signDto.getStusignstate();
        String classname = signDto.getClassname();
        String coursename = signDto.getCoursename(); //课程名
        int a = stuSignService.updateStuSign(num,signid,coursename);
        if(a==1) return Result.succ(200,"更新签到成功",a);
        else return Result.succ(123,"您已经签到过了",a);
    }

    @PostMapping("/SomeSignin")  //教师端批量签到
    public Result SomeSignin(@RequestBody  List<SomeSignDto> SomeSignin){
        List<SomeSignDto> a = SomeSignin;
        int b;
        for (int i=0;i<a.size();i++){
            SomeSignDto allsign = a.get(i);
            System.out.println("allsing"+allsign);
            if(allsign.getValues()==null ||allsign.getValues()=="" ||allsign.getValues().equals("")){//如果没选择签到状态，就跳过
                continue;
            }else {
                b = stuSignService.teaupdatasign(allsign.getStunum(), allsign.getSignid(),allsign.getValues());

            }
        }
       return Result.succ(200,"执行签到成功",a);
    }

    @PostMapping("/checksignplan")   //判断是否存在签到表
    public Result checksignplan(@RequestBody SignPlanDto signPlanDto){
        String classname = signPlanDto.getClassname();
        long signid = signPlanDto.getSignid();
        String coursename = signPlanDto.getCoursename();
        System.out.println("这里是checkplan:"+signid+":"+classname+":"+coursename);
        if(stuSignService.selectStuSignBySignId(signid,classname,coursename).size()!=0){  //签到表里有数据，说明已存在一张表
            System.out.println("能查出来！");
            return Result.succ(123,"已经存在签到表，无需创建",signid);
        }else{
            System.out.println("没能查出来！");
            return Result.succ(200,"还没有创建签到表",signid);
        }
    }

    @PostMapping("/getsignplan")  //根据班级、id、课程名查签到表
    public Result getsignplan(@RequestBody SignPlanDto signPlanDto){
        String classname = signPlanDto.getClassname();
        long signid = signPlanDto.getSignid();
        String coursename = signPlanDto.getCoursename();
        List<StuSign> ss = stuSignService.selectStuSignBySignId(signid,classname,coursename);
        if(ss.size()>0) return Result.succ(200,"根据所有对应信息查询签到表成功",ss);
        else return Result.fail(123,"没有签到表信息！",ss);
    }

    @PostMapping("/stugetsignplan")  //根据班级、id、是否开启签到查签到安排表
    public Result stugetsignplan(@RequestBody SignPlanDto signPlanDto){
        String classname = signPlanDto.getClassname();
        long signid = signPlanDto.getSignid();
        long signstate = signPlanDto.getSignstate();
        List<SignPlan> ss = stuSignMapper.selectStuSignPlanBysignstate(signid,classname,signstate);
        if(ss.size()>0) return Result.succ(200,"根据所有对应信息查询签到表成功",ss);
        else return Result.fail(123,"没有签到表信息！/还没有开启签到",signid);
    }

    @PostMapping("/signplan")  //教师端开启签到后生成签到表
    public Result SignPlan(@RequestBody SignPlanDto signPlanDto){
        String classname = signPlanDto.getClassname();
        int signstate = signPlanDto.getSignstate();  //0关闭签到 1开启签到
        long signid = signPlanDto.getSignid();
        String coursename = signPlanDto.getCoursename();

        if(stuSignService.selectOneSignPlan(signid,classname,coursename).size()!=0){
            return Result.fail(123,"已经存在签到计划表，签到表已经创建",signid);
        }else{
            int addsignplan = stuSignService.insertSignPlan(classname,0,signid,coursename); //创建签到计划表
        }

        if(stuSignService.selectStuSignBySignId(signid,classname,coursename).size()!=0){  //签到表里有数据，说明已存在一张表
            return Result.fail(123,"已经存在签到表，无需创建",signid);
        }
        List<Student> stus = studentService.selectStudentByClassName(classname);  //通过班级查到所有同意班级的学生
        int addnums=0;
        for(int i=0;i<stus.size();i++){
            Student s = stus.get(i);
            addnums += stuSignService.insertStuSign(s.getUsernum(),s.getUsername(),signid,"未签到",coursename,classname);
        }
        return Result.succ(200,"执行创建签到表成功",addnums);
    }

    @PostMapping("/updatesignplanstate")  //教师端开启/关闭签到计划表
    public Result updatesignplanstate(@RequestBody SignPlanDto signPlanDto){
        String classname = signPlanDto.getClassname();
        int signstate = signPlanDto.getSignstate();  //0关闭签到 1开启签到
        long signid = signPlanDto.getSignid();
        String coursename = signPlanDto.getCoursename();
        int i = stuSignService.updatesignplan(signid,signstate,classname,coursename);
        return Result.succ(200,"开启/关闭签到成功！",signstate);
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

    @GetMapping("/Allsignplan") //所有签到表
    public Result Allsignplan(){
        List<SignPlan> Allsignplan = stuSignMapper.selectAllSignPlan();
        return Result.succ(Allsignplan);
    }

}
