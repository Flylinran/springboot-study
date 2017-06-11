package cn.flylinran.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * author: huzunrong
 * date: 2017/6/6
 * description:
 * version: 1.0
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);


    @Pointcut("execution(public * cn.flylinran.controller.BookController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        LOGGER.info("url={}", request.getRequestURL());

        //method
        LOGGER.info("method={}", request.getMethod());

        //ip
        LOGGER.info("ip={}", request.getRemoteAddr());

        //类方法
        LOGGER.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        LOGGER.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        LOGGER.info("222222222222");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        LOGGER.info("response={}", object.toString());
    }

}
