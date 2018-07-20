package com.lijm.springmvc;

import com.lijm.springmvc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//TDD 测试驱动开发 例子调试
@Controller
public class NormalController {

    @Autowired
    DemoService demoService;

    @RequestMapping("/normal")
    public String saySomething(Model model){
        model.addAttribute("msg",demoService.saySomething());
        return "page";
    }

    @RequestMapping(value = "/testRest",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String testRest(){
        return demoService.saySomething();
    }
}
