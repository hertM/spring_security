package cn.tl.maventest.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 *
 * 自定义 错误的 处理器
 *
 */
public class MyAuthenticationFailureHandle implements AuthenticationFailureHandler {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        HashMap<String,String> hm = new HashMap<>();

        hm.put("success","false");

        String js = objectMapper.writeValueAsString(hm);

        System.out.println(e.getMessage());

        httpServletResponse.getWriter().println(js);

    }
}
