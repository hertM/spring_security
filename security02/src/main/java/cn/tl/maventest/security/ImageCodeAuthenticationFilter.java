package cn.tl.maventest.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 自定义 Filter
 *
 * 需要 继承 SpringSecurity 提供的一个 Filter
 *
 */
public class ImageCodeAuthenticationFilter extends OncePerRequestFilter {


    private AuthenticationFailureHandler authenticationFailureHandler;

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        //判断当前 请求 是否 是登录请求

        boolean b = httpServletRequest.getRequestURI().contains("/securityLogin");

        if (b) {//是登录 请求

            //获取到 输入的 验证码
            String imgCode = httpServletRequest.getParameter("imgCode");


            try {

                //获取到 缓存的 验证码
                String rand = (String)httpServletRequest.getSession().getAttribute("rand");

                if (imgCode == null ) {
                    throw new ImageCodeException("请输入验证码");
                }

                if (!imgCode.trim().equals(rand.trim())) {
                    throw new ImageCodeException("验证码不正确");
                }

                //报错 是 spring Security 的报错
            } catch (AuthenticationException e) {
                //交给 自定义的 失败处理器 去处理 引入 处理器

                authenticationFailureHandler.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);

                return;
            }


        }

        //否则 就全部 放行
        filterChain.doFilter(httpServletRequest,httpServletResponse);

    }
}
