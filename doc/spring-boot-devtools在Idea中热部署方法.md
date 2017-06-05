## spring-boot-devtools在Idea中热部署方法
### 一、概述
spring boob 项目在开发中修改了项目文件不能进行热部署，着实影响效率。

### 二、热部署配置
#### 2.1 POM文件

```
<!--添加依赖-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <!-- optional=true,依赖不会传递，该项目依赖devtools；之后依赖myboot项目的项目如果想要使用devtools，需要重新引入 -->
    <optional>true</optional>
</dependency>
```
**注**：project 中添加 spring-boot-maven-plugin,主要在**eclipse**中使用，idea中**不需要**添加此配置。

```
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <fork>true</fork>
            </configuration>
        </plugin>
    </plugins>
</build>
```
#### 2.2 idea 配置
当我们修改了java类后，IDEA默认是不自动编译的，而spring-boot-devtools又是监测classpath下的文件发生变化才会重启应用，所以需要设置IDEA的自动编译：
> - “File” -> “Settings” -> “Build,Execution,Deplyment” -> “Compiler”，选中打勾 “Build project automatically”。
> - 组合键：“Shift+Ctrl+Alt+/” ，选择 “Registry” ，选中打勾 “compiler.automake.allow.when.app.running”。

#### 2.3 缓存配置
#### 1. application.properties
```
spring.thymeleaf.cache=false
```
#### 2. Chrome禁用缓存
F12或者“Ctrl+Shift+I”，打开开发者工具，“Network” 选项卡下 选中打勾 “Disable Cache(while DevTools is open)” 。