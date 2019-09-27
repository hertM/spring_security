package cn.tl.maventest.security;


import org.springframework.security.core.AuthenticationException;

/**
 *
 * 继承 AuthenticationException 实现他的方法 注意 这个是 spring的报错
 *
 */
public class ImageCodeException extends AuthenticationException {


    public ImageCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public ImageCodeException(String msg) {
        super(msg);
    }
}
