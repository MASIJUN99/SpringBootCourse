package com.example.demo.service.impl;

import com.example.demo.service.TicketService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@DubboService  // 把这个注册到服务中心
@Component  // 使用Dubbo后使用这个注解，别用Service（其实也行，但是要用Spring的Service）
public class TicketServiceImpl implements TicketService {

  @Override
  public String getTicket() {
    return "001";
  }
}
