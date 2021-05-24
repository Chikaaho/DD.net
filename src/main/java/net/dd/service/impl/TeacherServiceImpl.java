package net.dd.service.impl;

import net.dd.mapper.TeacherMapper;
import net.dd.pojo.Teacher;
import net.dd.service.MailService;
import net.dd.service.TeacherService;
import net.dd.utils.MD5Util;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherMapper teacherMapper;
    private MailService mailService;

    @Autowired
    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Autowired
    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public List<Teacher> selectTeacher() {
        return teacherMapper.selectTeacher();
    }

    @Override
    public Teacher selectTeacherByNumber(long teachernum) {
        return teacherMapper.selectTeacherByNumber(teachernum);
    }

    @Override
    public int registTeacher(String username, String password, String activeCodes, String email, Long teacherNum) {
        Teacher teacher = teacherMapper.selectTeacherByName(username);
        if (teacher != null) {
            return 1 << 3;
        } else {
            username.replaceAll("\\s*", "");
            password.replaceAll("\\s*", "");
            String originalPassword = password; //原始密码
            String hashAlgorithmName = "MD5"; //加密方式
            int hashIterations = 2; //加密的次数
            //加密
            SimpleHash simpleHash = new SimpleHash(hashAlgorithmName
                    , originalPassword,
                    ByteSource.Util.bytes(username),  //根据用户名作为盐加密
                    hashIterations);
            String encryptionPassword = simpleHash.toBase64();
            teacherMapper.registTeacher(username
                    , encryptionPassword
                    , activeCodes, email, teacherNum);
            System.out.println("激活码=>" + activeCodes);
            String subject = "来自DD网的激活邮件";
            String context = "<a href=\"http://localhost:8081/user/checkCode?code=" + activeCodes + "\">点击此处激活" + "</a>";
            mailService.sendMimeMail(email, subject, context);
            return 1;
        }
    }

    @Override
    public int updateTeacher(long id, String username, String password) {
        return teacherMapper.updateTeacher(id, username.replaceAll("\\s*", ""), MD5Util.encode(password.replaceAll("\\s*", "")));
    }

    @Override
    public int deleteTeacher(long id) {
        return teacherMapper.deleteTeacher(id);
    }

    @Override
    public Teacher teacherLoginCheck(String username, String password) {
        Teacher teacher = teacherMapper.teacherLoginCheck(username.replaceAll("\\s*", ""), MD5Util.encode(password.replaceAll("\\s*", "")));
        if (teacher == null) {
            return null;
        }
        if (teacher.getIsDeleted() == 1) {
            return null;
        }
        return teacher;
    }

    @Override
    public Teacher registCheck(String activeCode) {
        return teacherMapper.registCheck(activeCode);
    }

    @Override
    public void modify(int status, String activeCodes) {
        teacherMapper.modify(status, activeCodes);
    }
}
