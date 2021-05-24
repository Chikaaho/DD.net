package net.dd.controller;

import net.dd.common.Result;
import net.dd.dto.BanjiDto;
import net.dd.dto.CourseDto;
import net.dd.dto.StudentDto;
import net.dd.dto.TeacherDto;
import net.dd.mapper.AdminMapper;
import net.dd.mapper.StudentMapper;
import net.dd.mapper.TeacherMapper;
import net.dd.pojo.Banji;
import net.dd.pojo.Course;
import net.dd.pojo.Student;
import net.dd.pojo.Teacher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin //所有域名均可访问该类下所有接口
//@CrossOrigin("http://localhost:8081") // 只有指定域名可以访问该类下所有接口
public class AdminController {
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    StudentMapper studentMapper;

    @GetMapping("/getAllbanji") //获取所有班级
    public Result getAllbanji(){
        List<Banji> list = adminMapper.selectBanji();
        if(list.size()==0) return Result.fail("没有查询到班级");
        else return Result.succ(200,"查询班级成功",list);
    }
    @GetMapping("/getAllteacher") //获取所有教师
    public Result getAllteacher(){
        List<Teacher> list = teacherMapper.selectTeacher();
        if(list.size()==0) return Result.fail("没有查询到教师");
        else return Result.succ(200,"查询教师成功",list);
    }
    @GetMapping("/getAllcourse") //获取所有课程
    public Result getAllcourse(){
        List<Course> list = adminMapper.selectCourse();
        if(list.size()==0) return Result.fail("没有查询到课程");
        else return Result.succ(200,"查询课程成功",list);
    }
    @PostMapping("/AddCourse") //添加课程
    public Result AddCourse(@RequestBody CourseDto courseDto){

        int course = adminMapper.insertCourse(courseDto.getCoursename(),
                                              courseDto.getStarttime(),
                                              courseDto.getEndtime(),
                                              courseDto.getClassesname(),
                                              courseDto.getTeachernum());
        if(course==0) return Result.fail("添加课程失败");
        else return Result.succ("添加课程成功");
    }
    @PostMapping("/EditCourse") //编辑课程
    public Result EditCourse(@RequestBody CourseDto courseDto){
        int course = adminMapper.updateCourse(
                courseDto.getCourseid(),
                courseDto.getCoursename(),
                courseDto.getStarttime(),
                courseDto.getEndtime(),
                courseDto.getClassesname(),
                courseDto.getTeachernum());
        if(course==0) return Result.fail("修改课程失败");
        else return Result.succ("修改课程成功");
    }
    @PostMapping("/DeleteCourse") //删除课程
    public Result DeleteCourse(@RequestBody CourseDto courseDto){

        int deletecourse = adminMapper.deleteCourse(courseDto.getCourseid());
        if(deletecourse==0) return Result.fail("删除课程失败");
        else return Result.succ("删除课程成功");
    }

    @PostMapping("/AddBanji") //添加班级
    public Result AddBanji(@RequestBody BanjiDto banjiDto){

        int course = adminMapper.insertBanji(banjiDto.getClassname(),banjiDto.getMajor());
        if(course==0) return Result.fail("添加班级失败");
        else return Result.succ("添加班级成功");
    }
    @GetMapping("/getAllbanjiandmember") //获取所有班级并获取人数
    public Result getAllbanjiandmember(){
        List<Banji> list = adminMapper.selectBanji();
        int member = 0;
        for(int i=0;i<list.size();i++){
            member = adminMapper.selectBanjimember(list.get(i).getClassname());
            list.get(i).setStunum(member);
        }
        if(list.size()==0) return Result.fail("没有查询到课程");
        else return Result.succ(200,"查询课程成功",list);
    }
    @PostMapping("/EditBanji") //编辑班级
    public Result EditBanji(@RequestBody BanjiDto banjiDto){

        int course = adminMapper.updateBanji(
                banjiDto.getClassesid(),
                banjiDto.getClassname(),
                banjiDto.getMajor());
        if(course==0) return Result.fail("修改班级失败");
        else return Result.succ("修改班级成功");
    }
    @PostMapping("/DeleteBanji") //删除班级
    public Result DeleteBanji(@RequestBody BanjiDto banjiDto){

        int deletecourse = adminMapper.deleteBanji(banjiDto.getClassesid());
        if(deletecourse==0) return Result.fail("删除班级失败");
        else return Result.succ("删除班级成功");
    }

    @PostMapping("/getStudentBybanji") //根据班级查询学生
    public Result getStudentBybanji(@RequestBody BanjiDto banjiDto){
        List<Student> list = studentMapper.selectStudentByClassName(banjiDto.getClassname());
        if(list.size()==0) return Result.fail("这个班级没有学生");
        else return Result.succ(200,"当前班级有学生",list);
    }

    @PostMapping("/AddStudent") //新添学生
    public Result AddStudent(@RequestBody StudentDto studentDto){
        String originalPassword = studentDto.getPassword(); //原始密码
        String hashAlgorithmName = "MD5"; //加密方式
        int hashIterations = 2; //加密的次数
        //加密
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName
                ,originalPassword,
                ByteSource.Util.bytes(studentDto.getUsername()),  //根据用户名作为盐加密
                hashIterations);
        String encryptionPassword = simpleHash.toBase64();
        int addstu = studentMapper.insertStudent(studentDto.getUsername(),encryptionPassword,studentDto.getUsernum(),studentDto.getClassname());
        if(addstu==0) return Result.fail("添加学生失败");
        else return Result.succ("添加学生成功");
    }

    @PostMapping("/EditStudent") //编辑学生
    public Result EditStudent(@RequestBody StudentDto studentDto){
        String originalPassword = studentDto.getPassword(); //原始密码
        String hashAlgorithmName = "MD5"; //加密方式
        int hashIterations = 2; //加密的次数
        //加密
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName
                ,originalPassword,
                ByteSource.Util.bytes(studentDto.getUsername()),  //根据用户名作为盐加密
                hashIterations);
        String encryptionPassword = simpleHash.toBase64();

        int editstu = studentMapper.AdminupdateStudent(
                studentDto.getUsername(),
                encryptionPassword,
                studentDto.getUsernum(),
                studentDto.getClassname());
        if(editstu==0) return Result.fail("修改学生失败");
        else return Result.succ("修改学生成功");
    }
    @PostMapping("/DeleteStudent") //删除学生
    public Result DeleteStudent(@RequestBody StudentDto studentDto){

        int deletecourse = studentMapper.AdmindeleteStudent(studentDto.getUsernum());
        if(deletecourse==0) return Result.fail("删除学生失败");
        else return Result.succ("删除学生成功");
    }

    @GetMapping("/getAllTeacher") //获取所有教师
    public Result getAllTeacher(){
        List<Teacher> list = teacherMapper.selectTeacher();
        if(list.size()==0) return Result.fail("没有查询到教师");
        else return Result.succ(200,"查询教师成功",list);
    }

    @PostMapping("/AddTeacher") //新添教师
    public Result AddTeacher(@RequestBody TeacherDto teacherDto){
        String originalPassword = teacherDto.getPassword(); //原始密码
        String hashAlgorithmName = "MD5"; //加密方式
        int hashIterations = 2; //加密的次数
        //加密
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName
                ,originalPassword,
                ByteSource.Util.bytes(teacherDto.getUsername()),  //根据用户名作为盐加密
                hashIterations);
        String encryptionPassword = simpleHash.toBase64();
        int addteacher = teacherMapper.AdminaddTeacher(teacherDto.getTeachernum(),teacherDto.getUsername(),encryptionPassword,teacherDto.getEmail());
        if(addteacher==0) return Result.fail("添加教师失败");
        else return Result.succ("添加教师成功");
    }
    @PostMapping("/EditTeacher") //编辑教师
    public Result EditStudent(@RequestBody TeacherDto teacherDto){
        String originalPassword = teacherDto.getPassword(); //原始密码
        String hashAlgorithmName = "MD5"; //加密方式
        int hashIterations = 2; //加密的次数
        //加密
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName
                ,originalPassword,
                ByteSource.Util.bytes(teacherDto.getUsername()),  //根据用户名作为盐加密
                hashIterations);
        String encryptionPassword = simpleHash.toBase64();

        int editstu = teacherMapper.AdminupdateTeacher(
                teacherDto.getTeachernum(),
                teacherDto.getUsername(),
                encryptionPassword,
                teacherDto.getEmail());
        if(editstu==0) return Result.fail("修改教师失败");
        else return Result.succ("修改教师成功");
    }

    @PostMapping("/DeleteTeacher") //删除教师
    public Result DeleteTeacher(@RequestBody TeacherDto teacherDto){

        int deleteteacher = teacherMapper.AdmindeleteTeacher(teacherDto.getTeachernum());
        if(deleteteacher==0) return Result.fail("删除教师失败");
        else return Result.succ("删除教师成功");
    }

}
