package cn.tl.maventest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    /**
     *
     * 登录的页面 地址
     *
     * @return
     *
     */
    @RequestMapping("/userlogin")
    public String login() {

        System.out.println("login=========");

        return "login";
    }


    /**
     *
     * 跳转 无权限的 页面
     *
     * @return
     */
    @RequestMapping("/error")
    public String error() {

        System.out.println("error=========");

        return "error";
    }

    @RequestMapping("/yzm")
    public String yzm() {

        System.out.println("yzm=========");

        return "yzm";
    }


}
