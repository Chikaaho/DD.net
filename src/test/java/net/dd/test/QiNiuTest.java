package net.dd.test;

import com.qiniu.common.QiniuException;
import net.dd.StarterApplication;
import net.dd.pojo.DdData;
import net.dd.service.QiNiuService;
import net.dd.service.impl.QiNiuServiceImpl;
import net.dd.utils.MD5Util;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

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

    String MD5Filename;

    @Test
    public void testUpload() throws QiniuException {
        MD5Filename = MD5Util.encode("helloworld");
        String result = qiniuService.uploadFile(new File("E:\\Datas\\photos\\other\\helloworld.jpg"), MD5Filename);
        System.out.println("访问地址： " + result);
    }

    @Test
    public void testDelete() throws QiniuException {
        String result = qiniuService.delete("fc5e038d38a57032085441e7fe7010b0");
        System.out.println(result);
    }

    @Test
    public void testDownload() throws IOException {
        String fileUrl = "http://qt1bcqgbl.hn-bkt.clouddn.com/fc5e038d38a57032085441e7fe7010b0";
        String fileLocalPath = "E:/ide/Projects/IdeaProject/DDNet/src/main/java/resources/" + MD5Util.encode("fc5e038d38a57032085441e7fe7010b0") + ".jpg";
        FileUtils.copyURLToFile(new URL(fileUrl), new File(fileLocalPath));
    }

}
