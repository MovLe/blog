package com.movle.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @ClassName LogAspect
 * @MethodDesc: TODO LogAspect功能介绍
 * @Author Movle
 * @Date 2021/1/13 下午3:05
 * @Version 1.0
 * @Email movle_xjk@foxmail.com
 **/

@Aspect
@Component
public class LogAspect {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Pointcut(value = "execution(* com.movle.web.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classmethod = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        RequestLog requestLog = new RequestLog(url,ip,classmethod,args);

        logger.info("Request:{}",requestLog);
    }

    @After("log()")
    public void doAfter(){
        //logger.info("--------------------------------------doAfter--------------------------------------");
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result){

        logger.info("Result:{}"+result);
    }
    private class RequestLog{
        private String url;
        private String ip;
        private String classmethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classmethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classmethod = classmethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classmethod='" + classmethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
