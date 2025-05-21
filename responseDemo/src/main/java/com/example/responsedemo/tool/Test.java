package com.example.responsedemo.tool;

import java.util.concurrent.TimeUnit;

public class Test {
    // 每秒请求30次
    private static WindowQpsControl ws = new WindowQpsControl(2, 1, TimeUnit.SECONDS);

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 15; i++) {
            new Thread(() -> {
                Test.hao();
            }).start();
        }
    }

    public static void hao() {
        boolean isExec = false;
        while (!isExec) {
            isExec = ws.isPass();
        }
        if (isExec) {
            System.out.println(System.currentTimeMillis());
        }

    }
}
