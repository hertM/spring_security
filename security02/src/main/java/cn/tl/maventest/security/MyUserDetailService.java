package cn.tl.maventest.security;

import cn.tl.maventest.domain.Permission;
import cn.tl.maventest.domain.User;
import cn.tl.maventest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *动态 授权
 *
 * 实现UserDetails 的接口 重写 方法
 *
 * 注入UserMapper 的对象 用来查询 信息
 *
 */
public class MyUserDetailService implements UserDetailsService {


    @Autowired
    private UserMapper userMapper;

    private static final Logger log = Logger.getLogger(MyUserDetailService.class.getSimpleName());


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        //根据用户名 查询 用户的信息
        User user = userMapper.findByUsername(s);

        //根据用户名 查询用户的 所有 权限
        List<Permission> list = userMapper.findPermissionByUsername(s);

        //遍历所有的 权限 构建 返回的对象 并且将 权限 赋值到里面
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();

        //循环 遍历 权限
        for (Permission per : list) {
            //***** 构建的 对象 是 GrantedAuthority 子类
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(per.getPertag());

            authorities.add(authority);//将 权限 添加
        }

        System.out.println(user.toString());

        //将所有的 权限 赋值给 用户 User
        user.setAuthorities(authorities);

        log.info(user.toString());

        return user;
    }
}
