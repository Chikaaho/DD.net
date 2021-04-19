package net.dd.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;


/**
 * @author Chika
 * @program DDNet
 * @create 2021/4/19 - 16:27
 **/
public class IDUtil {

    private static final Logger logger = LoggerFactory.getLogger(IDUtil.class);

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
        logger.debug("test");
    }

}
