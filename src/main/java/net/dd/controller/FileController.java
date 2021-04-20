package net.dd.controller;

import com.qiniu.common.QiniuException;
import net.dd.service.DdDataService;
import net.dd.service.QiNiuService;
import net.dd.service.impl.DdDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

@Controller
@RequestMapping("/file")
@CrossOrigin
public class FileController {

    private DdDataService dataService;
    private QiNiuService qiNiuService;

    @Autowired
    public void setDataService(DdDataService dataService) {
        this.dataService = dataService;
    }
    @Autowired
    public void setQiNiuService(QiNiuService qiNiuService) {
        this.qiNiuService = qiNiuService;
    }

    @RequestMapping("/")
    public String fileUpload(@RequestParam File file) {
        return "";
    }

    @RequestMapping("/")
    public String fileDelete(@RequestParam long id) {
        return "";
    }

    public void fileUpload() throws QiniuException {
        String result = qiNiuService.uploadFile(new File("E:\\Datas\\photos\\other\\helloworld.jpg"), "helloworld");
        System.out.println("访问地址： " + result);
    }

    public void fileDelete() throws QiniuException {
        String result = qiNiuService.delete("helloworld");
        System.out.println(result);
    }
}
