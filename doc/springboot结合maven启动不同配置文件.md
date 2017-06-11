## springboot结合maven启动不同配置文件

#### 三个文件
- application.yml
```
spring:
	profiles:
		active: dev
```
- application-dev.yml
```
test:
	name: dev
	age: 22
```
- application-prod.yml
```
test:
	name: prod
	age: 21
```
启动方式
> 第一种：手动修改application中的spring.profiles.active值
```
idea直接启动
mvn spring-boot:run
java -jar target/springboot-demo-0.0.1-SNAPSHOT.jar
```

> 第二种：命令行指定参数
```
项目路径下：mvn clean install
项目路径下：java -jar target/springboot-demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=[dev|prod]
```

