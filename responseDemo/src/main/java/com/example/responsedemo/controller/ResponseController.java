package com.example.responsedemo.controller;

import com.example.responsedemo.tool.WindowQpsControl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/respoonse")
public class ResponseController {

    @Value("${api.sleeptime}")
    private long sleepTime;
    private static WindowQpsControl ws = new WindowQpsControl(30, 1, TimeUnit.SECONDS);

    @GetMapping("/sendResponse")
    public String sendResponse(){
        boolean isExec = false;
        while (!isExec) {
            isExec = ws.isPass();
        }
        if (isExec) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "调用成功";
        }else{
            return "调用失败";
        }
    }

    @PostMapping("/sendResponse2")
    public String sendResponse2(){
        boolean isExec = false;
        while (!isExec) {
            isExec = ws.isPass();
        }
        if (isExec) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "调用成功";
        }else{
            return "调用失败";
        }
    }
}
