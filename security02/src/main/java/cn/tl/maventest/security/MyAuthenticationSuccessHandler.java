package cn.tl.maventest.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * 自定义 登录成功的 方法
 * 需要 实现 AuthenticationSuccessHandler 接口重写
 * onAuthenticationSuccess 方法
 *
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    //用来 做 JSON 的处理操作
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        HashMap<String,String> hm = new HashMap<>();

        hm.put("success","true");

        String js = objectMapper.writeValueAsString(hm);

        httpServletResponse.getWriter().println(js);

    }
}
