package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

  @RequestMapping({"/", "/index"})
  public String index() {
    return "index";
  }

  @RequestMapping("/toLogin")
  public String login() {
    return "views/login";
  }

  @RequestMapping("/{level}/{id}")
  public String toPage(@PathVariable("level") int level, @PathVariable("id") int id) {
    return "level/" + level + "/" + id;
  }
}
