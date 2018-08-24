package com.example.demo2.common;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TimeTask {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    //定义每3秒执行任务
    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime() {
        System.out.println("现在的时间是：" + dateFormat.format(new Date()));
    }
}
