package net.dd.controller;

import net.dd.common.Result;
import net.dd.dto.HomeWorkDto;
import net.dd.dto.HomeWorkPlanDto;
import net.dd.mapper.DdDataMapper;
import net.dd.mapper.HomeWorkMapper;
import net.dd.mapper.StudentMapper;
import net.dd.pojo.DdData;
import net.dd.pojo.HomeWork;
import net.dd.pojo.HomeWorkPlan;
import net.dd.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin //所有域名均可访问该类下所有接口
public class HomeWorkController {

    @Autowired
    HomeWorkMapper homeWorkMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    DdDataMapper ddDataMapper;

    @PostMapping("/PublishHomeWork")  //发布作业
    public Result PublishHomeWork(@RequestBody HomeWorkPlanDto homeWorkPlanDto) {
        System.out.println(homeWorkPlanDto.getFile());
        int phw = homeWorkMapper.insertHomeWorkPlan(homeWorkPlanDto.getTitle(),
                homeWorkPlanDto.getContent(),
                homeWorkPlanDto.getDeadline(),
                homeWorkPlanDto.getFile(),
                homeWorkPlanDto.getCoursename(),
                homeWorkPlanDto.getClassname());
        if (phw == 0) return Result.fail("插入失败");

        List<Student> students = studentMapper.selectStudentByClassName(homeWorkPlanDto.getClassname());
        int ihw = 0;
        for (int i = 0; i < students.size(); i++) {
            ihw = homeWorkMapper.insertHomeWork(homeWorkPlanDto.getTitle(),
                    homeWorkPlanDto.getCoursename(),
                    homeWorkPlanDto.getClassname(),
                    students.get(i).getUsernum());
        }
        if (ihw == 0) return Result.fail("生成作业表失败");
        else return Result.succ("生成作业表成功");
    }

    @PostMapping("/teacheruploadfile")  //教师上传资料
    public Result teacheruploadfile(@RequestBody HomeWorkPlanDto homeWorkPlanDto) {
        int phw = homeWorkMapper.teacheruploadfile(
                homeWorkPlanDto.getFile(),
                homeWorkPlanDto.getCoursename(),
                homeWorkPlanDto.getClassname());
        if (phw == 0) return Result.fail("插入上传信息失败");
        else return Result.succ("插入上传信息成功");
    }

    @PostMapping("/selectHomeWorkPlanByclassandcourse")  //教师端查询作业
    public Result selectHomeWorkPlanByclassandcourse(@RequestBody HomeWorkPlanDto homeWorkPlanDto) {
        List<HomeWorkPlan> swpbcc = homeWorkMapper.selectHomeWorkPlanByclassandcourse(homeWorkPlanDto.getCoursename(), homeWorkPlanDto.getClassname());
        if (swpbcc.size() == 0) return Result.fail("还没有作业！");
        else return Result.succ(200, "查询作业成功", swpbcc);
    }

    @PostMapping("/selectFileByclassandcourse")  //教师端查询文件
    public Result selectFileByclassandcourse(@RequestBody HomeWorkPlanDto homeWorkPlanDto) {
        List<HomeWorkPlan> swpbcc = homeWorkMapper.selectHomeWorkPlanByclassandcourse(homeWorkPlanDto.getCoursename(), homeWorkPlanDto.getClassname());
        List<DdData> ddData = new LinkedList<DdData>();
        for(int i = 0;i<swpbcc.size();i++){
            ddData.add(ddDataMapper.selectByFileKey(swpbcc.get(i).getFile())) ;
        }
        if (ddData.size() == 0) return Result.fail("没有文件！");
        else return Result.succ(200, "查询文件成功", ddData);
    }

    @PostMapping("/selectOneHomeWork")  //教师端查询单个作业详情
    public Result selectOneHomeWork(@RequestBody HomeWorkPlanDto homeWorkPlanDto) {
        List<HomeWork> sohw = homeWorkMapper.selectOneHomeWork(homeWorkPlanDto.getTitle(),homeWorkPlanDto.getCoursename(),homeWorkPlanDto.getClassname());
        if (sohw.size() == 0) return Result.fail("进入作业详情页失败！");
        else return Result.succ(200, "进入作业详情页成功", sohw);
    }

    @PostMapping("/stuselectAllHomeWork")  //学生端查询所有作业
    public Result stuselectAllHomeWork(@RequestBody HomeWorkDto homeWorkDto) {
        List<HomeWork> sohw = homeWorkMapper.stuselectAllHomeWork(homeWorkDto.getStunum(),homeWorkDto.getCoursename(),homeWorkDto.getClassname());
        if (sohw == null) return Result.fail("查询所有作业失败！");
        else return Result.succ(200, "查询所有作业成功", sohw);
    }


    @PostMapping("/stuselectOneHomeWork")  //学生端查询单个作业
    public Result stuselectOneHomeWork(@RequestBody HomeWorkDto homeWorkDto) {
        HomeWork sohw = homeWorkMapper.stuselectOneHomeWork(homeWorkDto.getStunum(),homeWorkDto.getTitle(),homeWorkDto.getCoursename(),homeWorkDto.getClassname());
        if (sohw == null) return Result.fail("进入作业失败！");
        else return Result.succ(200, "进入作业成功", sohw);
    }

    @PostMapping("/stusubmithomework")  //学生端提交作业
    public Result stusubmithomework(@RequestBody HomeWorkDto homeWorkDto) {
        int sshw = homeWorkMapper.stusubmithomework(homeWorkDto.getId(),homeWorkDto.getAnswer(),homeWorkDto.getFile());
        if (sshw == 0) return Result.fail("提交作业失败！");
        else return Result.succ(200, "提交作业成功", sshw);
    }

    @PostMapping("/teacherupdatehomework")  //教师端批改作业
    public Result teacherupdatehomework(@RequestBody HomeWorkDto homeWorkDto) {
        int sshw = homeWorkMapper.teacherupdatehomework(homeWorkDto.getId(),homeWorkDto.getScore());
        if (sshw == 0) return Result.fail("批改作业失败！");
        else return Result.succ(200, "批改作业成功", sshw);
    }
}
