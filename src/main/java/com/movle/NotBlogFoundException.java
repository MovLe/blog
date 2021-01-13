package com.movle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ClassName NotBlogFoundException
 * @MethodDesc: TODO NotBlogFoundException功能介绍
 * @Author Movle
 * @Date 2021/1/13 下午2:54
 * @Version 1.0
 * @Email movle_xjk@foxmail.com
 **/

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotBlogFoundException extends RuntimeException{

    public NotBlogFoundException(){

    }
    public NotBlogFoundException(String message){
        super(message);

    }
    public NotBlogFoundException(String message,Throwable cause){
        super(message, cause);
    }
}
