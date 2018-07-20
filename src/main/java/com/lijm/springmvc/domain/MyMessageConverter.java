package com.lijm.springmvc.domain;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {
    public MyMessageConverter(){
        //自定义媒体类型
        super(new MediaType("application","x-wisely", Charset.forName("utf-8")));
    }
    //该媒体类型只处理DemoObj类
    @Override
    protected boolean supports(Class clazz) {
        return DemoObj.class.isAssignableFrom(clazz);
    }

    //把入参根据约定逻辑转换成对象
    @Override
    protected DemoObj readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(inputMessage.getBody(),Charset.forName("utf-8"));
        String [] tempArr = temp.split("-");
        return new DemoObj(new Long(tempArr[0]),tempArr[1]);
    }

    //替换 o 的输出
    @Override
    protected void writeInternal(DemoObj o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "hello: " + o.getId() + "-" + o.getName();
         outputMessage.getBody().write(out.getBytes("utf-8"));
    }
}
