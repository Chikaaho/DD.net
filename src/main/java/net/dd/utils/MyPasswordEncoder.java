//package net.dd.utils;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * @author Chika
// * @program DDNet
// * @create 2021/3/9 - 16:06
// **/
//@Configuration
//public class MyPasswordEncoder implements PasswordEncoder {
//    @Override
//    public String encode(CharSequence rawPassword) {
//        return MD5Util.encode((String) rawPassword);
//    }
//
//    @Override
//    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//        return encodedPassword.equals(MD5Util.encode((String) rawPassword));
//    }
//}
