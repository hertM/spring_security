package cn.tl.maventest.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * 生成一个 实体 注意 这里 实体里面的 某些字段 必须与 实现的
 * UserDetail 的字段相同 类似：
 *
 *
 *     private String username;
 *     private boolean enabled;//是否可用
 *     private boolean accountNonExpired;//是否过期
 *     private boolean accountNonLocked;//是否锁定
 *     private boolean credentialsNonExpired;//证书是否过期
 *
 * 这样 可以  对接 UserDetail 的类
 *
 * 所以 在创建 数据库中的表 字段的时候 用这几个 字段 创建
 *
 *
 */
public class User implements UserDetails {

    private Integer userId;
    private String username;
    private String realName;
    private String password;
    private Date createTime;
    private Date endlogintime;
    private boolean enabled;//是否可用
    private boolean accountNonExpired;//是否过期
    private boolean accountNonLocked;//是否锁定
    private boolean credentialsNonExpired;//证书是否过期


    //手动添加一个属性 存储 用户拥有的所有权限
    private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndlogintime() {
        return endlogintime;
    }

    public void setEndlogintime(Date endlogintime) {
        this.endlogintime = endlogintime;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", realNmae='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", endlogintime=" + endlogintime +
                ", enabled=" + enabled +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", authorities=" + authorities +
                '}';
    }
}
