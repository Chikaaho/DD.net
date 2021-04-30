package net.dd.service.impl;

import net.dd.pojo.Student;
import net.dd.pojo.Teacher;
import net.dd.service.StudentService;
import net.dd.service.TeacherService;
import net.dd.utils.MD5PasswordEncoder;
import net.dd.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Chika
 * @program DDNet
 * @create 2021/4/19 - 15:15
 **/
@Service("userDetailsService")
@Deprecated
public class UserDetailsServiceImpl implements UserDetailsService {

    TeacherService teacherService;
    StudentService studentService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Teacher teacher = teacherService.selectTeacherByName(username);
        Student student = studentService.selectStudentByName(username);
        if (teacher == null && student == null) {
            throw new UsernameNotFoundException("该用户不存在");
        } else if (student == null) {
            List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(String.valueOf(teacher.getRoles()));
            return new User(teacher.getUsername(), new MD5PasswordEncoder().encode(teacher.getPassword()), auth);
        } else {
            List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(String.valueOf(student.getRoles()));
//            System.out.println(auth);
            return new User(student.getUsername(), new BCryptPasswordEncoder().encode("123456"), auth);
        }
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
