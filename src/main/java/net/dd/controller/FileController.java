package net.dd.controller;

import com.qiniu.common.QiniuException;
import io.swagger.annotations.ApiModelProperty;
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

    /**
    * @param
    * fileType: 文件类型 —— 0：txt文本文件
    *                      1：img图片文件
    *                       2：video视频文件
    **/

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
            return "sys/index";
        }
        Map<Object, Object> map = new HashMap<>();
        dataService.insertFile(new DdData(fileType, fileName));
        map.put("fileType", fileType);
        map.put("fileName", fileName);
        JSON_DATA_MAP.put(fileName, map);
        System.out.println("访问地址 => " + result);
        return "sys/index";
    }

    // key = fileName
    @RequestMapping("/fileDelete.do")
    public String fileDelete(@RequestParam long id, @RequestParam String key) {
        String result;
        try {
            result = qiNiuService.delete(key);
        } catch (QiniuException e) {
            logger.error(e.toString());
            return "forward:/file/toFileSetPage";
        }
        dataService.deleteById(id);
        JSON_DATA_MAP.remove(key);
        System.out.println(result);
        return "forward:/file/toFileSetPage";
    }

    @RequestMapping("/fileData")
    @ResponseBody
    public Map<Object, Object> getJsonDataMap() {
        return JSON_DATA_MAP;
    }

    @RequestMapping("/toFileSetPage")
    @ApiModelProperty(value = "页面跳转")
    public String toFileSetPage() {
        return "sys/file/fileSet";
    }

}
