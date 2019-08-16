package com.hdf.springboot2_x.chapter9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-16 14:06
 */
@Controller
@RequestMapping("/interceptor")
public class InterceptorController {

    @GetMapping("/start")
    @ResponseBody
    public String start() {
        return "welcome boy!";
    }
}
