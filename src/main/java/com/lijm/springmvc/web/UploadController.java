package com.lijm.springmvc.web;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody String upload(@RequestParam("files") MultipartFile[] files){
        for(MultipartFile file :files) {
            if(file.isEmpty()){
                continue;
            }
            try {
                FileUtils.writeByteArrayToFile(new File("e:/upload/" + file.getOriginalFilename()), file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }
        return "ok";
    }
}
