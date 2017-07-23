package cn.flylinran.handle;

import com.alibaba.fastjson.JSONObject;
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
 * date: 2017/6/12
 * description: 前端请求记录
 */
@Aspect
@Component
public class LogHandle {

    private static Logger logger = LoggerFactory.getLogger(LogHandle.class);

    @Pointcut("execution(public * cn.flylinran.controller.*.*(..))")
    public void log() {
        //空方法，简化下面的操作
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("接收请求 -> [{}]{} (From -> [{}])", request.getMethod(), request.getRequestURL(), request.getRemoteAddr());
        logger.info("处理请求 -> [{}.{}]", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        logger.info("前端传参 -> {}", JSONObject.toJSONString(request.getParameterMap()));
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
    }

    @After("log()")
    public void doAfter(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;

        logger.info("处理时间 -> {}ms", executeTime);
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("后台响应 -> {}", JSONObject.toJSONString(object));
    }
}