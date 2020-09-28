package com.liu.blog.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Service
public class LogService {

    public String logUpload(MultipartFile file) throws Exception {
        if (file == null || file.isEmpty()) {
            throw new NoSuchFieldException("未选择需上传的日志文件");
        }

        String filePath = new File("logs_app").getAbsolutePath();
        System.out.println("路径:"+filePath);
        File fileUpload = new File(filePath);
        if (!fileUpload.exists()) {
            fileUpload.mkdirs();
        }

        fileUpload = new File(filePath, file.getOriginalFilename());
        if (fileUpload.exists()) {
            throw new NoSuchFieldException("上传的日志文件已存在");
        }

        try {
            file.transferTo(fileUpload);

            return "成功";
        } catch (IOException e) {
            throw new NoSuchFieldException("上传日志文件到服务器失败：" + e.toString());
        }
    }
}
