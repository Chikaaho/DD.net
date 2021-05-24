package net.dd.test;

import com.qiniu.common.QiniuException;
import com.sun.istack.Nullable;
import net.dd.StarterApplication;
import net.dd.enums.ApiEnum;
import net.dd.pojo.DdData;
import net.dd.service.DdDataService;
import net.dd.service.QiNiuService;
import net.dd.service.impl.QiNiuServiceImpl;
import net.dd.utils.IDUtil;
import net.dd.utils.MD5Util;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chika
 * @program DDNet
 * @create 2021/4/20 - 16:00
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarterApplication.class)
public class QiNiuTest {

    QiNiuService qiniuService;
    DdDataService ddDataService;

    @Autowired
    public void setService(QiNiuService service) {
        this.qiniuService = service;
    }
    @Autowired
    public void setDdDataService(DdDataService ddDataService) {
        this.ddDataService = ddDataService;
    }

    String MD5Filename;

    @Test
    public void testUpload() throws QiniuException {
        MD5Filename = MD5Util.encode("demo");
        String result = qiniuService.uploadFile(new File(""), MD5Filename);
//        ddDataService.insertFile();
        System.out.println("访问地址： " + result);
    }

    @Test
    public void fileUpload() {
        String filePath = "E:/Datas/photos/other/helloworld.jpg";
        String addUrl = "/18soft/18240369";
        String result;
        String fileName = "";
        String fileKey = MD5Util.encode(IDUtil.getUUID());;
        if (addUrl != null) {
            fileName = addUrl.substring(1) + "/";
        }
        fileName += fileKey;
        try {
            result = qiniuService.uploadFile(new File(filePath), fileName);
            String[] split = filePath.split("\\.");
            String fileType = "." + split[split.length - 1];
            ddDataService.insertFile(fileType, fileKey, addUrl);
        } catch (QiniuException e) {
//            logger.warn(e.toString());
            return;
        }
        System.out.println("访问地址： " + result);
    }

    @Test
    public void fileDownload() {
        long id = 1;
        String fileLocalPath = "E:/ide/Projects/IdeaProject/DDNet/src/main/resources/";
        DdData ddData = ddDataService.selectByFileId(id);
        StringBuffer fileUrl = new StringBuffer();
        fileUrl.append("http://qt1bcqgbl.hn-bkt.clouddn.com");
        if (!ddData.getAddUrl().isEmpty() && !ddData.getAddUrl().isBlank()) {
            fileUrl.append(ddData.getAddUrl());
        }
        fileUrl.append("/").append(ddData.getFileKey());
        String type = ddData.getFileType();
        String fileName = "下载测试";
        try {
            FileUtils.copyURLToFile(new URL(fileUrl.toString()), new File(fileLocalPath + fileName + type));
        } catch (IOException e) {
//            logger.warn(e.toString());
            e.printStackTrace();
        }
    }

    @Test
    public void selectAllFile() {
        List<DdData> ddData = ddDataService.selectAllFile();
        Map<String, DdData> map = new HashMap<>();
        for (DdData ddDatum : ddData) {
            String addUrl = ddDatum.getAddUrl();
            map.put(addUrl, ddDatum);
        }
        System.out.println(map);
    }

    @Test
    public void fileDelete() {
        long id = 2;
        DdData ddData = ddDataService.selectByFileId(id);
        StringBuilder fileKey = new StringBuilder();
        String addUrl = ddData.getAddUrl();
        if (!addUrl.isEmpty() && !addUrl.isBlank()) {
            fileKey.append(addUrl.substring(1));
        }
        fileKey.append("/").append(ddData.getFileKey());
        try {
            qiniuService.delete(fileKey.toString());
            ddDataService.deleteById(id);
        } catch (QiniuException e) {
//            logger.warn(e.toString());
        }
    }

    @Test
    public void testDelete() throws QiniuException {
        DdData ddData = ddDataService.selectByFileId(3);
        String result = qiniuService.delete(ddData.getFileKey());
        ddDataService.deleteById(3);
        System.out.println(result);
    }

    @Test
    public void testDownload() throws IOException {
        String fileUrl = "http://qt1bcqgbl.hn-bkt.clouddn.com/fe01ce2a7fbac8fafaed7c982a04e229";
        DdData ddData = ddDataService.selectByFileId(3);
        String fileKey = MD5Util.encode(ddData.getFileKey());
        String fileLocalPath = "E:/ide/Projects/IdeaProject/DDNet/src/main/resources/" + fileKey + ".text";
        FileUtils.copyURLToFile(new URL(fileUrl), new File(fileLocalPath));
    }

}
