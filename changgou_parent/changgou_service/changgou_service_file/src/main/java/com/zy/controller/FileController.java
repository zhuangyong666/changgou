package com.zy.controller;

import com.zy.entity.Result;
import com.zy.entity.StatusCode;
import com.zy.util.FastDFSClient;
import com.zy.util.FastDFSFile;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
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

    @PostMapping("upload")
    public Result uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty() || file == null) {
            return Result.fail(StatusCode.PARAMERROR);
        }
        String originalFilename = file.getOriginalFilename();
        if (StringUtils.isEmpty(originalFilename)){
            throw new RuntimeException("文件不存在");
        }
        //获取文件的扩展名称  abc.jpg   jpg
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        FastDFSFile fastDFSFile = new FastDFSFile(originalFilename, file.getBytes(), extName);
        String path = FastDFSClient.uploadFile(fastDFSFile);
        return Result.success().addData(path);
    }
}
