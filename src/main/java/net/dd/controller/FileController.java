package net.dd.controller;

import com.qiniu.common.QiniuException;
import com.sun.istack.Nullable;
import io.swagger.annotations.ApiModelProperty;
import net.dd.enums.ApiEnum;
import net.dd.pojo.DdData;
import net.dd.service.DdDataService;
import net.dd.service.QiNiuService;
import net.dd.utils.MD5Util;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.URL;
import java.util.*;


@RestController
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

    /*
    * fileName => 由获取文件时自动截取
    * 拼接地址长度限定
    * */
    /*
    *  eg: https://xxxx/filePath/addUrl/fileName
    * */
    @ApiModelProperty(value = "文件上传服务")
    @RequestMapping("/upload.do")
    public ApiEnum fileUpload(@RequestParam String filePath, @Nullable@RequestParam String addUrl, @RequestParam String fileName, @RequestParam int fileType){
        String result;
        // 文件名MD5扰乱
        String MD5FileName = MD5Util.encode(fileName);
        try {
            result = qiNiuService.uploadFile(new File(filePath), MD5FileName);
            if (result.trim().length() != 0) {
                Map<Object, Object> midCurrMap = new HashMap<>();
                if (addUrl != null || addUrl.trim().length() != 0) {
                    String[] split = addUrl.split("/");
                    List<String> list = new ArrayList<>();
                    for (String s : split) {
                        if (s.trim().length() != 0) {
                            list.add(s);
                        }
                    }
                    midCurrMap.put("addUrl", list);
                    /*
                    * @addUrl: 拼接地址
                    * {
                    *   addUrl : {
                    *               t1,
                    *               t2,
                    *               t3
                    *             },
                    *   fileType : {
                    *               0 : .txt,
                    *               1 : .jpg,
                    *               2 : .mp4
                    *              }
                    *
                    * }
                    * */

                }

                JSON_DATA_MAP.put(MD5FileName, midCurrMap);
            }
        } catch (QiniuException e) {
            logger.warn(e.toString());
            return ApiEnum.FILE_UPLOAD_FAILED;
        }
        System.out.println("访问地址： " + result);
        return ApiEnum.FILE_UPLOAD_SUCCESS;
    }

    @ApiModelProperty(value = "文件下载")
    @RequestMapping("/fileDownload")
    public ApiEnum fileDownload(@RequestParam long id, @RequestParam String fileLocalPath) {
        DdData ddData = dataService.selectByFileId(id);
        StringBuffer fileUrl = new StringBuffer();
        String type = "";
        try {
            Map<Object, Object> o = (Map<Object, Object>) JSON_DATA_MAP.get(ddData.getFileKey());
            int fileType = (int) o.get("fileType");
            fileUrl.append((String) o.get("fileUrl"));
            switch (fileType) {
                case 0:
                    type = ".txt";
                    break;
                case 1:
                    type = ".jpg";
                    break;
                case 2:
                    type = ".mp4";
                    break;
                default:
                    break;
            }
            FileUtils.copyURLToFile(new URL(fileUrl.toString()), new File(fileLocalPath + type));
        } catch (IOException e) {
            logger.warn(e.toString());
            return null;
        }
        return null;
    }

    @ApiModelProperty(value = "文件删除服务")
    @RequestMapping("/fileDelete.do")
    public ApiEnum fileDelete(@RequestParam long id) {
        DdData ddData = dataService.selectByFileId(id);
        String fileKey = ddData.getFileKey();
        try {
            qiNiuService.delete(fileKey);
            JSON_DATA_MAP.remove(fileKey);
        } catch (QiniuException e) {
            logger.warn(e.toString());
            return ApiEnum.FILE_DELETE_FAILED;
        }
        return ApiEnum.FILE_DELETE_SUCCESS;
    }

    @RequestMapping("/fileData")
    public String getJsonDataMap() {
        return JSON_DATA_MAP.toString();
    }

    public static void main(String[] args) {
        String addUrl = "/a/b/c/d";
        String[] split = addUrl.split("/");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            if (s.trim().length() != 0) {
                list.add(s);
            }
        }
        System.out.println(list);
    }

}
