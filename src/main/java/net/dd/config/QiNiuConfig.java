package net.dd.config;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Chika
 * @program DDNet
 * @create 2021/4/20 - 15:48
 **/
@Configuration
public class QiNiuConfig {

    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.zone}")
    private String zone;

    @Bean
    public com.qiniu.storage.Configuration qiNiuConfig() {
        return switch (zone) {
            case "huadong" -> new com.qiniu.storage.Configuration(Region.huanan());
            case "huabei" -> new com.qiniu.storage.Configuration(Region.huabei());
            case "huanan" -> new com.qiniu.storage.Configuration(Region.huanan());
            case "beimei" -> new com.qiniu.storage.Configuration(Region.beimei());
            default -> throw new RuntimeException("存储区域配置错误");
        };
    }


    /**
     * 构建一个七牛上传工具实例
     */
    @Bean
    public UploadManager uploadManager() {
        return new UploadManager(qiNiuConfig());
    }

    /**
     * 认证信息实例
     */
    @Bean
    public Auth auth() {
        return Auth.create(accessKey, secretKey);
    }

    /**
     * 构建七牛空间管理实例
     */
    @Bean
    public BucketManager bucketManager() {
        return new BucketManager(auth(), qiNiuConfig());
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }

}
