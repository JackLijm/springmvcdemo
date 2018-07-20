package com.lijm.springmvc.web;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

//通过sse服务器推送消息到服务器，要浏览器支持sse
@Controller
public class SseController {

    @RequestMapping(value = "/push",produces = {"text/event-stream"})
   public @ResponseBody String push(){
       int nam  = new Random().nextInt(10);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Test 1,2,3" + nam + "\n\n";
   }
}

