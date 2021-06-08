# Shiro

这其实就是一个非常简单的maven项目，导入了shiro以及
配套的日志依赖。

代码都是官方github里的quickstart里的。

现在我们就来一点一点分析一下这些代码。

## shiro.ini

[shiro.ini](src/main/resources/shiro.ini)

### users

略过一些很明确的东西，我们看到代码段的[users]“标签”

```ini
[users]
# user 'root' with password 'secret' and the 'admin' role
root = secret, admin
# user 'guest' with the password 'guest' and the 'guest' role
guest = guest, guest
# user 'presidentskroob' with password '12345' ("That's the same combination on
# my luggage!!!" ;)), and role 'president'
presidentskroob = 12345, president
# user 'darkhelmet' with password 'ludicrousspeed' and roles 'darklord' and 'schwartz'
darkhelmet = ludicrousspeed, darklord, schwartz
# user 'lonestarr' with password 'vespa' and roles 'goodguy' and 'schwartz'
lonestarr = vespa, goodguy, schwartz
```

这里不用想都是定义了一些用户，这个形式是怎么样的呢？

不难总结出是以下的形式

`username = password, roles...`

这里我想到了一个骚操作，如果我用户的用户名一样密码不一样权限就不一样会怎样？即

```ini
[users]
admin = 123456, admin
admin = 1234567, root
```

跑了一下，只能按照最后定义的内容来。

### roles

看一下roles标签。

```ini
[roles]
# 'admin' role has all permissions, indicated by the wildcard '*'
# 可以做一切
admin = *
# The 'schwartz' role can do anything (*) with any lightsaber:
# 只能做那个开头的
schwartz = lightsaber:*
# The 'goodguy' role is allowed to 'drive' (action) the winnebago (type) with
# license plate 'eagle5' (instance specific id)
goodguy = winnebago:drive:eagle5
```

这个没啥好说的吧...就定义了一下权限，这个后面结合
springboot案例来说。

## log4j.properties

[log4j.properties](src/main/resources/log4j.properties)

日志的东西，没什么好说的

## Quickstart

[Quickstart](src/main/java/Quickstart.java)


