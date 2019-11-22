package com.atguigu.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

//    @Scheduled(cron = "0 * * * * MON-SAT")
//    @Scheduled(cron = "0,1,2,3,4 * * * * MON-SAT")
//    @Scheduled(cron = "0-4 * * * * MON-SAT")
    @Scheduled(cron = "0/4 * * * * MON-SAT") //每四秒执行一次
    public void hello(){
        System.out.println("hello....");
    }
}
