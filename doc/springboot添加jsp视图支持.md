# spring boot添加jsp视图支持
> **注意：** 官方不推荐使用jsp
- pom.xml添加依赖
```
		<!-- servlet 依赖. -->
        <!--<dependency>-->
            <!--<groupId>javax.servlet</groupId>-->
            <!--<artifactId>javax.servlet-api</artifactId>-->
            <!-<scope>provided</scope>-->
        <!--</dependency>-->
        <!--<dependency>-->
            <!--<groupId>javax.servlet</groupId>-->
            <!--<artifactId>jstl</artifactId>-->
        <!--</dependency>-->
        <!--<!-- tomcat 的支持.-->
        <!--<dependency>-->
            <!--<groupId>org.springframework.boot</groupId>-->
            <!--<artifactId>spring-boot-starter-tomcat</artifactId>-->
            <!--<scope>provided</scope>-->
        <!--</dependency>-->
        <!--<dependency>-->
            <!--<groupId>org.apache.tomcat.embed</groupId>-->
            <!--<artifactId>tomcat-embed-jasper</artifactId>-->
            <!--<scope>provided</scope>-->
        <!--</dependency>-->
```
- application.properties添加jsp支持
```
#配置jsp视图
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
```
