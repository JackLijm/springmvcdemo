package com.lijm.springmvc.web;

import com.lijm.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//自定义媒体类型
@Controller
public class ConverterController {
    @RequestMapping(value = "/convert",produces ={"application/x-wisely"})
    public @ResponseBody DemoObj convert(@RequestBody DemoObj demoObj){
        return demoObj;
    }
}
