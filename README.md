# AOP와 BindResult를 이용한 로그 파일 만드는 법

![blog](https://postfiles.pstatic.net/MjAyMDA4MTdfOTQg/MDAxNTk3NjQyNzU1MjY1.wegGpyy9N6Z2jnUqWWC8yz2nezoUqfhIUpC4NSQVDxcg.7Q2Pdnza4II3ggt5MeI0SIxM-eVKdgUq62QsHSnvO58g.PNG.getinthere/Screenshot_38.png?type=w773)

## 로그 레벨

- 로그는 해당 level 위로는 다 기록된다. 예를 들어 info level이면 info, warn, error
- debug -> info -> warn -> error

## 참고 주소

- http://logback.qos.ch/manual/
- https://blog.naver.com/getinthere/221799123006

```xml
[2020-08-17 14:32:35:342619][http-nio-8080-exec-1] INFO  c.c.l.config.aop.warn.BindingAdvice - 인포 찍혀?
[2020-08-17 14:32:35:342619][http-nio-8080-exec-1] DEBUG c.c.l.config.aop.warn.BindingAdvice - 디버그 찍혀?
[2020-08-17 14:32:35:342619][http-nio-8080-exec-1] ERROR c.c.l.config.aop.warn.BindingAdvice - 에러 찍혀?
[2020-08-17 14:32:35:342619][http-nio-8080-exec-1] WARN  c.c.l.config.aop.warn.BindingAdvice - com.cos.logtest.controller.IndexController : user() 올바른 형식의 이메일 주소여야 합니다
```

## 의존성

```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-aop</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
```
