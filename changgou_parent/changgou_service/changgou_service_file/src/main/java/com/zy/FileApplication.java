package com.zy;

import com.zy.config.FastDFSProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author zhuangy
 * @version V1.0
 * @Title: FileApplication
 * @Package com.zy
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/12/28 0028 17:01
 **/
@SpringBootApplication
@EnableConfigurationProperties({FastDFSProperties.class})
public class FileApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class);
    }
}
