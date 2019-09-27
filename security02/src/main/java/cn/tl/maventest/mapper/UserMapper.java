package cn.tl.maventest.mapper;

import cn.tl.maventest.domain.Permission;
import cn.tl.maventest.domain.User;


import java.util.List;

public interface UserMapper {


    /**
     *
     * 查询 当前用户的 方法
     *
     * @param username
     * @return
     */
    public User findByUsername(String username);


    /**
     *
     * 根据 用户的名字 查询 用户的 权限
     *
     * @param username
     * @return
     */
    public List<Permission> findPermissionByUsername(String username);







}
