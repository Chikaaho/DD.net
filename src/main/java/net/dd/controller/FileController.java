package net.dd.controller;

import com.qiniu.common.QiniuException;
import net.dd.pojo.DdData;
import net.dd.service.DdDataService;
import net.dd.service.QiNiuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/file")
@CrossOrigin
public class FileController {

    private DdDataService dataService;
    private QiNiuService qiNiuService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final Map<Object, Object> JSON_DATA_MAP = new HashMap<>();

    @Autowired
    public void setDataService(DdDataService dataService) {
        this.dataService = dataService;
    }
    @Autowired
    public void setQiNiuService(QiNiuService qiNiuService) {
        this.qiNiuService = qiNiuService;
    }

    @RequestMapping("/upload.do")
    public String fileUpload(@RequestParam String filePath, @RequestParam String fileName, @RequestParam int fileType){
        String result;
        try {
            result = qiNiuService.uploadFile(new File(filePath), fileName);
        } catch (QiniuException e) {
            logger.error(e.toString());
            return "";
        }
        JSON_DATA_MAP.clear();
        Map<Object, Object> map = new HashMap<>();
        dataService.insertFile(new DdData(fileType, fileName));
        map.put("fileType", fileType);
        map.put("fileName", fileName);
        JSON_DATA_MAP.put(fileName, map);
        System.out.println("访问地址： " + result);
        return "";
    }

    @RequestMapping("/")
    public String fileDelete(@RequestParam long id, @RequestParam String key) {
        String result;
        try {
            result = qiNiuService.delete(key);
        } catch (QiniuException e) {
            logger.error(e.toString());
            return "";
        }
        System.out.println(result);
        return "";
    }

    @RequestMapping("/")
    @ResponseBody
    public Map<Object, Object> getJsonDataMap() {
        return JSON_DATA_MAP;
    }

}
