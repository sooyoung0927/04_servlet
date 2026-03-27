package com.wanted.servlet.h_cookie_session;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    /*comment
    *  doPost : 사용자 입력 user_id, user_pwd 를 세션에 저장하며 유효시간 설정
    *  doGet : 저장된 세션의 값을 꺼내와 jsp 로 전달하여 결과 표시
    * */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        // 세션 가져오는 구문
        HttpSession session = req.getSession(false); // 기존 세션이 없으면 null 반환
        String loggedInUser = null;
        String pwd = null;

        if(session != null){
            loggedInUser = session.getAttribute("loggedInUser").toString();
            pwd = session.getAttribute("pwd").toString();
        }

        // jsp 에서 사용하는 값 담아주기
        req.setAttribute("loggedInUser",loggedInUser!=null ? loggedInUser : "로그인 안 됨");
        req.setAttribute("pwd",pwd!=null ? pwd : "비밀번호 없음");

        RequestDispatcher rd = req.getRequestDispatcher("/h_cookie_session/session-result.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String userid = req.getParameter("user_id");
        String userpwd = req.getParameter("user_pwd");

    }
}
