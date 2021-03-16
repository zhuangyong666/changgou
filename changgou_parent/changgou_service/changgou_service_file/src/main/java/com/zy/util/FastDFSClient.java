package com.zy.util;

import com.zy.entity.NetworkAddressSymbol;
import lombok.extern.slf4j.Slf4j;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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
    static {
        try {
            String absolutePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
            ClientGlobal.init(absolutePath);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("初始化fastDfs失败");
        }
    }

    /**
     * @param fastDFSFile
     * @return
     * @throws Exception
     * @description 上传文件
     */
    public static String uploadFile(FastDFSFile fastDFSFile) throws Exception {
        NameValuePair[] meta_list = new NameValuePair[1];
        NameValuePair nameValuePair = new NameValuePair("md5", fastDFSFile.getMd5());
        meta_list[0] = nameValuePair;
        StorageClient storageClient = getStorageClient();
        String[] infos = storageClient.upload_appender_file(fastDFSFile.getContent(), fastDFSFile.getExt(), meta_list);
        String path = NetworkAddressSymbol.getHttpAgreement() + FastDFSClient.getStorageAddress() + NetworkAddressSymbol.SLASH + infos[0] + NetworkAddressSymbol.SLASH + infos[1];
        return path;
    }

    /**
     * @param groupName
     * @param remoteFilename
     * @return
     * @throws Exception
     * @description 删除文件
     */
    public static int deleteFile(String groupName, String remoteFilename) throws Exception {
        StorageClient storageClient = getStorageClient();
        return storageClient.delete_file(groupName, remoteFilename);
    }

    /**
     *
     * @param groupName
     * @param remoteFilename
     * @return
     * @throws Exception
     * @description 下载文件
     */
    public static InputStream downloadFile(String groupName, String remoteFilename) throws Exception {
        StorageClient storageClient = getStorageClient();
        return new ByteArrayInputStream(storageClient.download_file(groupName, remoteFilename));
    }


    /**
     * @return 获取fastDfsTracker 服务端对象
     * @throws IOException
     */
    private static TrackerServer getTrackerServer() throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer connection = trackerClient.getConnection();
        return connection;
    }

    /**
     * @return
     * @throws IOException
     * @description 获取Storage客户端
     */
    private static StorageClient getStorageClient() throws IOException {
        TrackerServer trackerServer = getTrackerServer();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        return storageClient;
    }

    /**
     * @return
     * @throws Exception
     * @decription 获取storage 地址及端口
     */
    public static String getStorageAddress() throws Exception {
        return getTrackerServer().getInetSocketAddress().getHostName() + NetworkAddressSymbol.COLON + ClientGlobal.g_tracker_http_port;
    }
}

