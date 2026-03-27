package com.wanted.servlet.h_cookie_session;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet ("/cookie")
public class CookieServlet extends HttpServlet {

    /*comment
    *  Cookie는 클라이언트와 서버 간에 상태 정보를 유지하기 위해 사용되는 작은 데이터 저장 공간이다
    *  쿠키의 구조는 이름과 값 쌍으로 구정되며 선택적으로 만료시간, 경로 등의 속성을 부여할 수 있띠
    *  예) name=홍길동 형태로 저장된다
    *  쿠키의 특징
    *  - 클라이언트 측에서 저장되므로 보안에 취약하다
    *  - 크기에 제한이 있다 (4kb)
    *  */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Post에 담겨있는 내용이 안 깨지게 하기 위한 인코딩
        req.setCharacterEncoding("UTF-8");

        String cookieValue = req.getParameter("cookieValue");
        Cookie cookie = new Cookie("userValue",cookieValue);
        cookie.setMaxAge(60*60); // 1시간 설정
        resp.addCookie(cookie);

        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String savedValue = "없음";

        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for(Cookie cookie : cookies){
                if("userValue".equals(cookie.getName())){
                    savedValue=cookie.getValue();
                    break;
                }
            }
        }

        // Cookie에 있는 값을 View에 보여주기 위해 넣어주기
        req.setAttribute("savedValue",savedValue);

        // 지금까지 우리는 path에 요청을 처리할 수 있는 서블릿 클래스만 넣었다
        RequestDispatcher rd = req.getRequestDispatcher("/h_cookie_session/cookie-result.jsp");
        rd.forward(req,resp);
    }
}
