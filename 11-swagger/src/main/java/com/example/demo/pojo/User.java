package com.example.demo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户实体类")
// @Api(注释)
public class User {

  @ApiModelProperty("用户名")
  private String username;
  @ApiModelProperty("密码")
  private String password;

}
