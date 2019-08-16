package com.hdf.springboot2_x.chapter9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-16 12:35
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @GetMapping("/upload/page")
    public String uploadPage() {
        return "/file/upload";
    }


    //使用HttpServletRequest做参数
    @PostMapping("/upload/request")
    @ResponseBody
    public String uploadRequest(HttpServletRequest request) {
        boolean flag = false;
        MultipartHttpServletRequest mreq = null;
        if (request instanceof MultipartHttpServletRequest) {
            mreq = (MultipartHttpServletRequest) request;
        } else {
            return "上传失败";
        }

        //获取MultipartFile文件信息
        MultipartFile mf = mreq.getFile("file");
        //获取源文件名称
        String fileName = mf.getOriginalFilename();
        File file = new File(fileName);
        try {
            mf.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

    //使用MultipartFile做参数
    @PostMapping("/upload/multipart")
    @ResponseBody
    public String uploadMultipartFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        File dest = new File(fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }

        return "上传成功";
    }


    //使用part做参数
    @PostMapping("/upload/part")
    @ResponseBody
    public String uploadMultipartFile(Part file) {
        String fileName = file.getSubmittedFileName();
        try {
            file.write(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }

        return "上传成功";
    }
}
