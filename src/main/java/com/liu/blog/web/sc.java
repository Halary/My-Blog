package com.liu.blog.web;

import com.liu.blog.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;




@Scope("prototype")
@Controller
@RequestMapping("/log")
public class sc {

    @Autowired
    private LogService logService;



    /**
     * 跳转到文件上传界面
     *
     * */

    @GetMapping("/sc")
    public String sc(){
        return "sc";
    }

    /**
     * 上传日志接口
     *
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/upload")
    @ResponseBody
    public String logUpload(@RequestParam("file") MultipartFile file) throws Exception {
        return logService.logUpload(file);
    }
}
