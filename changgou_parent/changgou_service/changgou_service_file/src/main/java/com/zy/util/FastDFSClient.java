package com.zy.util;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.zy.entity.Result;
import com.zy.entity.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @author zhuangy
 * @version V1.0
 * @Title: FastDFSClient
 * @Package utils
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/12/25 0025 16:00
 **/
@Slf4j
@Component
public class FastDFSClient {
    @Autowired
    private FastFileStorageClient storageClient;

    public String uploadFile(MultipartFile multipartFile) {
        try {
            String filename = multipartFile.getOriginalFilename();
            InputStream inputStream = multipartFile.getInputStream();
            StorePath storePath = storageClient.uploadFile(inputStream, multipartFile.getSize(), filename, null);
            return storePath.getPath();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(StatusCode.FILEUPLOADERROR.getMessage(), e.getMessage());
            return null;
        }
    }



}
