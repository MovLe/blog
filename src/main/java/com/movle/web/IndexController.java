package com.movle.web;

import com.movle.NotBlogFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName IndexController
 * @MethodDesc: TODO IndexController功能介绍
 * @Author Movle
 * @Date 2021/1/13 下午2:08
 * @Version 1.0
 * @Email movle_xjk@foxmail.com
 **/

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }

    @GetMapping("/archives")
    public String archives(){
        return "archives";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
    @GetMapping("/tags")
    public String tags(){
        return "tags";
    }
    @GetMapping("/types")
    public String types(){
        return "types";
    }
}
