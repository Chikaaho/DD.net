package net.dd.test;

import com.qiniu.common.QiniuException;
import net.dd.StarterApplication;
import net.dd.service.QiNiuService;
import net.dd.service.impl.QiNiuServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author Chika
 * @program DDNet
 * @create 2021/4/20 - 16:00
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarterApplication.class)
public class QiNiuTest {

    @Autowired
    QiNiuService qiniuService;

    @Autowired
    public void setService(QiNiuService service) {
        this.qiniuService = service;
    }


    @Test
    public void testUpload() throws QiniuException {
        String result = qiniuService.uploadFile(new File("E:\\Datas\\photos\\other\\helloworld.jpg"), "helloworld");
        System.out.println("访问地址： " + result);
    }

    @Test
    public void testDelete() throws QiniuException {
        String result = qiniuService.delete("helloworld");
        System.out.println(result);
    }

}
