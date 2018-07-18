package com.lijm.springmvc.web.ch4_3;

import com.lijm.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {
    @RequestMapping(produces = "text/plain;charset=utf-8")
    public @ResponseBody String index(HttpServletRequest request){
        return "url:" + request.getRequestURL() + " can access";
    }
    @RequestMapping(value = "/pathvar/{str}",produces = "text/plain;charset=utf-8")
    public @ResponseBody String demoPathVar(HttpServletRequest request, @PathVariable String str){
        return "url:" + request.getRequestURL() + " can access,Str: " + str;
    }
    @RequestMapping(value = "/requestParam",produces = "text/plain;charset=utf-8")
    public @ResponseBody String passRequestParam(HttpServletRequest request, Long id){
        return "url:" + request.getRequestURL() + " can access,id: " + id;
    }
    @RequestMapping(value = "/obj",produces = "text/plain;charset=utf-8")
    public @ResponseBody String passObj(HttpServletRequest request, DemoObj obj){
        return "url:" + request.getRequestURL() + " can access,obj: " + obj;
    }
    @RequestMapping(value = {"/name1","/name2"},produces = "text/plain;charset=utf-8")
    public @ResponseBody String remove(HttpServletRequest request){
        return "url:" + request.getRequestURL() + " can access";
    }
}
