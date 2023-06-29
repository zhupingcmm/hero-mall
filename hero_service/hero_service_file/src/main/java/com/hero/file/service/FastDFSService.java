package com.hero.file.service;

import com.hero.file.pojo.FastDFSFile;

/**
 * @Author: pzhu
 * @Date: 2023/6/29 7:10
 */
public interface FastDFSService {
    /**
     * 下载文件
     * @param groupName
     * @param remoteFileName
     * @return
     */
    byte [] download(String groupName, String remoteFileName);


    /**
     * 上传文件
     * @param file
     * @return
     */
    String [] uploads (FastDFSFile file);

}
