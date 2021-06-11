package com.example.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

  // 告诉他这是个异步方法
  @Async
  public void hello() {
    System.out.println("数据开始处理");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // 数据处理完毕
    System.out.println("数据处理完毕");
  }

}
