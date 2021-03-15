package net.dd.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Chika
 * @program DDNet
 * @create 2021/3/9 - 16:06
 **/
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.contentEquals(charSequence);
    }
}
