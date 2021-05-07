package net.dd.config.shiro;


import net.dd.pojo.Student;
import net.dd.service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

//自定义的UserRealm
public class StudentRealm extends AuthorizingRealm {

    @Autowired
    StudentService studentService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.printf("执行了=>授权doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.addStringPermission("user:add");

        //拿到当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        Student currentUser = (Student) subject.getPrincipal(); //拿到Student对象
        switch (currentUser.getRoles()){
            case 3: info.addStringPermission("3"); //3级权限
            case 2: info.addStringPermission("2"); //2级权限
            case 1: info.addStringPermission("1"); //1级权限
            case 0: info.addStringPermission("0"); System.out.printf("通过");//0级权限
        }


        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken Token) throws AuthenticationException {
        System.out.println("执行了=>认证doGetAuthenticationInfo");

        UsernamePasswordToken userToken =(UsernamePasswordToken) Token;
        System.out.println("userToken="+userToken.getUsername());
        //连接真实的数据库
        Student student = studentService.selectStudentByName(userToken.getUsername());

       // System.out.printf("pwd:"+userToken.getPassword().toString());
        if(student==null){ //没有这个人
            return null;//抛出异常 UnknownAccountException
        }


//        Subject currentSubject = SecurityUtils.getSubject();
//        Session session = currentSubject.getSession();
//        session.setAttribute("loginUser",student);
        //可以加密：MD5 MD5盐值加密
        //密码认证，shiro做
        //将此用户存放到登录认证info中，无需自己做密码对比Shiro会为我们进行密码对比校验
        return new SimpleAuthenticationInfo(student,student.getPassword(),ByteSource.Util.bytes(student.getUsername()),getName());

    }
}

