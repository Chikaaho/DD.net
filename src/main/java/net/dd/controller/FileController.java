package net.dd.controller;

import com.qiniu.common.QiniuException;
import com.sun.istack.Nullable;
import io.swagger.annotations.ApiModelProperty;
import net.dd.enums.ApiEnum;
import net.dd.pojo.DdData;
import net.dd.service.DdDataService;
import net.dd.service.QiNiuService;
import net.dd.utils.IDUtil;
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
    private static final String QINIU_URL = "http://qt1bcqgbl.hn-bkt.clouddn.com";

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
     *
     * */
    /*   .xxx
     *  eg: https://xxxx/filePath/addUrl/fileName
     * */
    @ApiModelProperty(value = "文件上传服务")
    @RequestMapping("/upload.do")
    public void fileUpload(@RequestParam File filePath, @Nullable @RequestParam String addUrl, @RequestParam String fileType) {
        String result;
        String fileName = "";
        String fileKey = MD5Util.encode(IDUtil.getUUID());
        if (addUrl != null) {
            fileName = addUrl.substring(1) + "/";
        }
        fileName += fileKey;
        try {
            result = qiNiuService.uploadFile(filePath, fileName);
            dataService.insertFile(fileType, fileKey, addUrl);
        } catch (QiniuException e) {
            logger.warn(e.toString());
            return;
        }
        System.out.println("访问地址： " + result);
    }

    @ApiModelProperty(value = "文件下载")
    @RequestMapping("/fileDownload")
    public void fileDownload(@RequestParam long id, @RequestParam String fileLocalPath) {
        DdData ddData = dataService.selectByFileId(id);
        StringBuffer fileUrl = new StringBuffer();
        fileUrl.append(QINIU_URL);
        if (!ddData.getAddUrl().isEmpty() && !ddData.getAddUrl().isBlank()) {
            fileUrl.append(ddData.getAddUrl());
        }
        fileUrl.append("/").append(ddData.getFileKey());
        String type = ddData.getFileType();
        try {
            FileUtils.copyURLToFile(new URL(fileUrl.toString()), new File(fileLocalPath + ddData.getFileKey() + type));
        } catch (IOException e) {
            logger.warn(e.toString());
        }
    }

    @ApiModelProperty(value = "文件删除服务")
    @RequestMapping("/fileDelete.do")
    public ApiEnum fileDelete(@RequestParam long id) {
        DdData ddData = dataService.selectByFileId(id);
        StringBuilder fileKey = new StringBuilder();
        String addUrl = ddData.getAddUrl();
        if (!addUrl.isEmpty() && !addUrl.isBlank()) {
            fileKey.append(addUrl.substring(1));
        }
        fileKey.append("/").append(ddData.getFileKey());
        try {
            qiNiuService.delete(fileKey.toString());
            dataService.deleteById(id);
        } catch (QiniuException e) {
            logger.warn(e.toString());
            return ApiEnum.FILE_DELETE_FAILED;
        }
        return ApiEnum.FILE_DELETE_SUCCESS;
    }

    @ApiModelProperty("查看文件")
    @RequestMapping("/selectAll")
    public Map<String, DdData> selectAllFile() {
        List<DdData> ddData = dataService.selectAllFile();
        Map<String, DdData> map = new HashMap<>();
        for (DdData ddDatum : ddData) {
            String addUrl = ddDatum.getAddUrl();
            map.put(addUrl, ddDatum);
        }
        return map;
    }

    public static void main(String[] args) {
        String i = "/d/s/x";
        System.out.println(i.substring(1) + "/" + IDUtil.getUUID());
    }

}
