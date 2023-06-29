package com.hero.file.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: pzhu
 * @Date: 2023/6/27 14:42
 */
@Setter
@Getter
public class FastDFSFile {
    // 文件名
    private String name;
    // 文件内容
    private byte [] content;
    // 文件扩展名
    private String ext;
    //文件MD5摘要值
    private String md5;
    // 文件上传者
    private String author;


    public FastDFSFile(String name, byte[] content, String ext) {
        this.name = name;
        this.content = content;
        this.ext = ext;
    }
}
