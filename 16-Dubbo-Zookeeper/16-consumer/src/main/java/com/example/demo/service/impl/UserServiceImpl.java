package com.example.demo.service.impl;

import com.example.demo.service.TicketService;
import com.example.demo.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service  // 这里是放在容器里的注解
public class UserServiceImpl implements UserService {

  // 需要拿到provider的getTicket
  /*
  通过pom坐标或者定义路径相同的接口名获取注册中心的服务

  1. 通过pom坐标

  2. 在我们的包下面创建路径结构一摸一样的接口，例如本例子就是service.TicketService
   */


  @Reference  // 引用我们注册中心的服务，
  TicketService ticketService;

  public void getTicket() {
    String ticket = ticketService.getTicket();
    System.out.println("拿到了：" + ticket);
  }

}
