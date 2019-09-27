package cn.tl.maventest.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/all")
public class AllTestController {

    @RequestMapping("/to")
    @ResponseBody
    public String skip() {
        System.out.println("你好啊");

        return "hell";
    }


    @RequestMapping("/hello")
    public String hello(Model model) {

        //获取登录后的用户对象 信息
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal != null ) {

            if (principal instanceof UserDetails) {
                UserDetails user = (UserDetails) principal;

                String username = user.getUsername();

                model.addAttribute("userName",username);
            }

        }


        return "hello";
    }


    @RequestMapping("/add")
    public String add() {

        System.out.println("login..........");
        return "product/add";
    }



    @RequestMapping("/list")
    public String list() {

        return "product/list";
    }



    @RequestMapping("/update")
    public String update() {

        return "product/update";
    }


    @RequestMapping("/delete")
    public String delete() {

        return "product/delete";
    }



}
