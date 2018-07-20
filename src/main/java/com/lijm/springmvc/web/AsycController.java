package com.lijm.springmvc.web;

import com.lijm.springmvc.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * 通过servlet3.0异步推送消息
 */
@Controller
public class AsycController {
    @Autowired
    PushService pushService;
    @RequestMapping("/defer" )
    @ResponseBody
    public DeferredResult <String> deferredCall(){
          return pushService.getAsyncUpdate();
    }
}
