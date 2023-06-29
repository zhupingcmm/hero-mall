package com.hero.file.util;

import com.hero.file.pojo.FastDFSFile;
import lombok.extern.slf4j.Slf4j;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import java.io.IOException;

/**
 * @Author: pzhu
 * @Date: 2023/6/27 14:40
 */
@Slf4j
public class FastDFSClient {

    static {
        try {
            String filePath = ClassLoader.getSystemResource("fdfs_client.conf").getPath();
            ClientGlobal.init(filePath);
        } catch (Exception e) {
            log.error("FastDFS Client Init Fail!",e);
        }
    }


    /**
     * 下载文件
     * @param groupName
     * @param remoteFileName
     * @return
     */
    public static byte [] download(String groupName, String remoteFileName) {
        try {
            StorageClient client = getStorageClient();
            return client.download_file(groupName, remoteFileName);
        } catch (Exception e) {
            log.error("Exception: Get File from Fast DFS failed", e);
        }
        return null;
    }

    /**
     * 上传文件
     * @param file
     * @return
     */
    public static String [] uploads (FastDFSFile file) {
        NameValuePair[] metaList = new NameValuePair[1];
        metaList[0] = new NameValuePair("author", file.getAuthor());
        // 接收返回数据
        String [] uploadResults = null;
        StorageClient storageClient = null;

        try {
            storageClient = getStorageClient();

            uploadResults = storageClient.upload_file(file.getContent(), file.getExt(), metaList);
        } catch (Exception e) {
            log.error("Exception when uploadind the file:" + file.getName(), e);
        }

        if (uploadResults == null && storageClient!=null) {
            log.error("upload file fail, error code:" + storageClient.getErrorCode());
        }
        //获取组名
        String groupName = uploadResults[0];
        //获取文件存储路径
        String remoteFileName = uploadResults[1];
        return uploadResults;
    }

    /***
     * 获取Tracker服务地址
     * @return
     * @throws IOException
     */
    public static String getTrackerUrl() throws IOException {
        return "http://"+getTrackerServer().getInetSocketAddress().getHostString()+":"+ClientGlobal.getG_tracker_http_port()+"/";
    }

    /***
     * 获取Storage客户端
     * @return
     * @throws IOException
     */
    private static StorageClient getStorageClient() throws IOException {
        TrackerServer trackerServer = getTrackerServer();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        return  storageClient;
    }

    /***
     * 获取Tracker
     * @return
     * @throws IOException
     */
    private static TrackerServer getTrackerServer() throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        return  trackerClient.getConnection();
    }
}
