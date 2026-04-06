package com.wanted.servlet.i_filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/auth/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("로그인 필터 초기화");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        /*comment
        *  /auth 하위 요청을 필터링 하며 \
        *  해당 필터는 session에 loggedInUser 값이 없으면
        *  500에러를 리턴하는 것이 아닌 로그인을 할 수 있는 페이지로 redirect 시킬 것이다 */

        // 기존 세션을 가져옴
        HttpSession session = req.getSession(false);
        if(session == null || session.getAttribute("loggedInUser")==null){
            resp.sendRedirect("/h_cookie_session/cookie_session.html");
        }else{
            chain.doFilter(req,resp);
        }

    }

    @Override
    public void destroy() {
        System.out.println("로그인 필터 파괴됨");
    }
}
