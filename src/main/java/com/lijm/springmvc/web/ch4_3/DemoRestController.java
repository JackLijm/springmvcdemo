package com.lijm.springmvc.web.ch4_3;

import com.lijm.springmvc.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //组合注解，@Controller + @ResponseBody
@RequestMapping("/rest")
public class DemoRestController {
    @RequestMapping(value = "/getjson",produces={"application/json;charset=utf-8"})
    public DemoObj getJson(DemoObj demoObj) {
        return new DemoObj(demoObj.getId() + 1, demoObj.getName() + "yy");
    }

    @RequestMapping(value = "/getXml",produces={"application/xml;charset=utf-8"})
    public DemoObj getXml(DemoObj demoObj) {
        return new DemoObj(demoObj.getId() + 1, demoObj.getName() + "yy");
    }
}
