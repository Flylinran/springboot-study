package cn.flylinran.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * author: huzunrong
 * date: 2017/6/12
 * description: 前端请求记录
 */
@Aspect
@Component
public class LogHandle {

    private Logger logger = LoggerFactory.getLogger(LogHandle.class);
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * cn.flylinran.controller.*.*(..))")
    public void log() {}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("接收请求 -> [{}]{} (From -> [{}])", request.getMethod(), request.getRequestURL(), request.getRemoteAddr());
        logger.info("处理请求 -> [{}.{}]", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        logger.info("前端传参 -> {}", JSONObject.toJSONString(request.getParameterMap()));
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("处理时间 -> {}ms", System.currentTimeMillis() - startTime.get());

        logger.info("后台响应 -> {}", JSONObject.toJSONString(object));
    }
}