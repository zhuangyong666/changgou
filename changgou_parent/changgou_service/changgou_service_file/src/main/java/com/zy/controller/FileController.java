package com.zy.controller;

import com.zy.entity.Result;
import com.zy.entity.StatusCode;
import com.zy.util.FastDFSClient;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zhuangy
 * @version V1.0
 * @Title: FileController
 * @Package com.zy.controller
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/12/28 0028 13:58
 **/
@RestController
@RequestMapping("file")
@Api("文件管理")
public class FileController {
    @Autowired
    private FastDFSClient fastDFSClient;

    @PostMapping("upload")
    public Result uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty() || file == null) {
            return Result.fail(StatusCode.PARAMERROR);
        }
        String path = fastDFSClient.uploadFile(file);
        return Result.success().addData(path);
    }
}
