测试条件装配

```java
@ConditionalOnBean(name = "xx")
```

这句话意味着当容器中存在xx名的组件时才能运行这个**配置类**

```java
@ConditionalOnMissingBean(name = "xx")
```

这句话意味着当容器中不存在xx名的组件时才能运行这个**配置类**