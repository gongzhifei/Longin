package com.gzf.web.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author gongzhifei
 */
@RestController
@RequestMapping(value = "/file")
public class FileController {

    @ApiOperation(value = "文件上传")
    @PostMapping
    public String upload(MultipartFile file) throws IOException {
        System.out.println("文件名："+file.getName());
        System.out.println("原始文件名："+file.getOriginalFilename());
        System.out.println("文件大小："+file.getSize());
        System.out.println("文件类型："+file.getContentType());
        File localFile = new File("D:/","bootdemo.txt");
        //将上传的文件复制到本地
        file.transferTo(localFile);
        //返回绝对路径
        return localFile.getAbsolutePath();
    }

    @GetMapping("/{fileName}")
    public void download(@PathVariable("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try (InputStream inputStream = new FileInputStream(new File("D:/"+fileName+".txt"));
             OutputStream outputStream = response.getOutputStream()) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=test.txt");
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
            outputStream.close();
        }
    }

}
