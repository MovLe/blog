package com.movle.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ControllerExcptionHandler
 * @MethodDesc: TODO ControllerExcptionHandler功能介绍
 * @Author Movle
 * @Date 2021/1/13 下午2:17
 * @Version 1.0
 * @Email movle_xjk@foxmail.com
 **/

@ControllerAdvice
public class ControllerExceptionHandler {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler (HttpServletRequest request,Exception e) throws Exception {
        logger.error("REQUEST URL:{},EXCEPTION:{}",request.getRequestURL(),e);

        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class)!=null){
            throw e;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception",e);

        mv.setViewName("error/error");

        return  mv;

    }

}
