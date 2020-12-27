package com.zy.config;

import com.zy.util.FastDFSClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * @author zhuangy
 * @version V1.0
 * @Title: FastDFSConfig
 * @Package com.zy.config
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/12/27 0027 10:07
 **/
@Configuration
@Import(FastDFSClient.class) // 导入FastDFS-Client组件
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING) // 解决jmx重复注册bean的问题
public class FastDFSConfig {
}
