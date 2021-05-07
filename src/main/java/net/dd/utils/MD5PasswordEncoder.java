/*
package net.dd.utils;

import net.dd.enums.ApiEnum;
import net.dd.exception.GlobalException;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

*/
/**
 * @author Chika
 * @program DDNet
 * @create 2021/4/29 - 14:19
 **//*

public class MD5PasswordEncoder implements PasswordEncoder {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String encode(CharSequence rawPassword) {
        return MD5Util.encode(rawPassword.toString());
    }

    public String encode (CharSequence userId, CharSequence rawPassword) {
        return MD5Util.convertMD5(userId.toString(), rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (rawPassword == null) {
            throw new IllegalArgumentException("rawPassword cannot be null");
        }
        if (encodedPassword == null || encodedPassword.length() == 0) {
            this.logger.warn("Empty encoded password");
            return false;
        }
        return MessageDigest.isEqual(rawPassword.toString().getBytes(StandardCharsets.UTF_8), encodedPassword.getBytes(StandardCharsets.UTF_8));
    }

}
*/
