# 总结几个要点

## 1.这个项目中，MyMvcConfig的作用

1. 他其实是一个配置类，所有组件都在其中注册，例如**国际化组件**。
2. 他是一个MVC配置类，这一点就与我们config其他类一样的作用，可以重写某些方法。

## 2.什么是自定义配置

比如我们的MyMvcConfig就是自定义配置类，它通过重写的方式来修改内部方法。

比如我们在utils中新建了一个日期转换器，那么我们就需要在MyMvcConfig中找到原有的方法，
通过重写的方式来应用我们写的自定义转换器。（就我个人而言，我感觉把国际化内容放在utils更合适？）

## 3.