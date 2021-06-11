package com.example.pojo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
// 在所有的pojo都会序列化
public class User implements Serializable {

  private String username;
  private String password;

}
