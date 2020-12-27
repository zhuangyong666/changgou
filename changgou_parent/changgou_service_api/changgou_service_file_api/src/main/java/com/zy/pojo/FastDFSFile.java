package com.zy.pojo;

import lombok.Data;

/**
 * @author zhuangy
 * @version V1.0
 * @Title: FastDFSFile
 * @Package com.zy.pojo
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/12/25 0025 14:37
 **/
@Data
public class FastDFSFile {
    private String name;
    private byte[] content;
    private String ext;
    private String md5;
    private String author;
}
