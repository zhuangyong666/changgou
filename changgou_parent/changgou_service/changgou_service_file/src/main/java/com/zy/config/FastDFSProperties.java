package com.zy.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhuangy
 * @version V1.0
 * @Title: FastDFSProperties
 * @Package com.zy.config
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/12/27 0027 10:15
 **/
@Data
@ConfigurationProperties(prefix = "fdfs")
@Slf4j
public class FastDFSProperties implements InitializingBean {
    private String reqHost;
    private String reqPort;
    private long soTimeOut;
    private String webServerUrl;


    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("fdfs.reqHost is {},fdfs.reqPort is {},fdfs.webServerUrl is {}", getReqHost(), getReqPort(), getWebServerUrl());
        if (StringUtils.isBlank(reqHost)) {
            throw new IllegalStateException("reqHost 未配置");
        }
    }
}
