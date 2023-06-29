package com.hero.file.controller;

import com.hero.entity.Result;
import com.hero.file.pojo.FastDFSFile;
import com.hero.file.service.FastDFSService;
import com.hero.file.util.FastDFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Author: pzhu
 * @Date: 2023/6/29 7:14
 */
@RestController
@RequestMapping("/file")
public class FastDFSController {


//    @Autowired
//    private FastDFSService fastDFSService;

    @PostMapping("/upload")
    public Result<String> upload(@RequestParam("file")MultipartFile file) {
        String path = "";

        try {
            path = saveFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Result.success(path);
    }


    @RequestMapping("/download")
    public Result<byte[]> download(@RequestParam String groupName, @RequestParam String filePath) {
        byte [] content = FastDFSClient.download(groupName, filePath);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment",
                new String("bd.jpg".getBytes(StandardCharsets.UTF_8),StandardCharsets.ISO_8859_1));
        return Result.success(content);
    }


    private String saveFile (MultipartFile multipartFile) throws IOException {
       String filename = multipartFile.getOriginalFilename();

       byte [] content = multipartFile.getBytes();

       String ext = "";
       if (filename != null && !"".equals(filename)) {
           ext = filename.substring(filename.lastIndexOf("."));
       }

        FastDFSFile fastDFSFile = new FastDFSFile(filename, content, ext);

       String [] uploadResults = FastDFSClient.uploads(fastDFSFile);

        String path = FastDFSClient.getTrackerUrl() + uploadResults[0] + "/" + uploadResults[1];
        return path;
    }
}
