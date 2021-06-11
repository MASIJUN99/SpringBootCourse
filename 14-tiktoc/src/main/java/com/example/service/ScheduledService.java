package com.example.service;

import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {


  // 在一个特定时间执行
  // cron计划任务
  // 秒 分 时 日 月 年  周几
  @Scheduled(cron = "0 * * * * 0-7")
  public void hello() {
    System.out.println(new Date().toString() + "Hello!");
  }

}
