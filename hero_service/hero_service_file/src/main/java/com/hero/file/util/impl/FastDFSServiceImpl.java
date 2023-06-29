package com.hero.file.util.impl;

import com.hero.file.pojo.FastDFSFile;
import com.hero.file.service.FastDFSService;
import com.hero.file.util.FastDFSClient;
import org.springframework.stereotype.Service;

/**
 * @Author: pzhu
 * @Date: 2023/6/29 7:12
 */
@Service
public class FastDFSServiceImpl implements FastDFSService {


    @Override
    public byte[] download(String groupName, String remoteFileName) {
        return FastDFSClient.download(groupName, remoteFileName);
    }

    @Override
    public String[] uploads(FastDFSFile file) {
        return FastDFSClient.uploads(file);
    }
}
