package net.dd;


import net.dd.mapper.AdminMapper;
import net.dd.mapper.StudentMapper;
import net.dd.pojo.Admin;
import net.dd.pojo.Student;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.lang.Nullable;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 新增用户
     * 账号密码的加密、加盐
     */
    @Test
    public void addUser()
    {
        String originalPassword = "123456"; //原始密码
        String hashAlgorithmName = "MD5"; //加密方式
        int hashIterations = 2; //加密的次数

        //盐
//        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        //加密
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName
                ,originalPassword,
                ByteSource.Util.bytes("admin"),
                hashIterations);
        String encryptionPassword = simpleHash.toBase64();

        //创建用户信息
        Admin adminInfo = new Admin();
        adminInfo.setUsername("admin");
        adminInfo.setPassword(encryptionPassword);
        //userInfo.setSalt(salt);
        //userInfo.setBlogUrl("https://blog.csdn.net/pan_junbiao");
        //userInfo.setBlogRemark("您好，欢迎访问 pan_junbiao的博客");
       // userInfo.setState(2);

        //执行新增
        adminMapper.insertAdmin(1101,adminInfo.getUsername(),adminInfo.getPassword());

        //打印结果
//        System.out.println("用户ID：" + studentInfo.getId());
//        System.out.println("用户姓名：" + studentInfo.getUsername());
//        System.out.println("原始密码：" + originalPassword);
//        System.out.println("加密密码：" + studentInfo.getPassword());
//        System.out.println("盐：" + ByteSource.Util.bytes("shirotest"));

    }

}
