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

        // 로그인 버튼을 눌렀을 때
        // ID,PWD 값을 request 객체에서 꺼내담기
        String userid = req.getParameter("user_id");
        String userpwd = req.getParameter("user_pwd");

        if(userid != null && !userpwd.isEmpty()){
            // 사용자의 아이디와 비밀번호를 저장하기 위한 Session 객체
            HttpSession session = req.getSession(true);
            // 동일한 사용자인지 확인하기 위한 변수 생성
            String existUser = (String)session.getAttribute("loggedInUser");
            /*
            * toString()은 널포인트익셉션 에러가 뜸 -> .은 내부 값 참조를 해야하는데 로그인 전 시점에서는 참조할 대상값이 없어서 널에러 뜸
            * cast 연산자 (String)으로 형변환 해줘야함 -> 참조를 하지 않아서 에러가 나지 않음
            * */

            if(existUser == null || existUser.equals(userid)){
                session.setAttribute("loggedInUser",userid);

                if(userpwd != null && !userpwd.isEmpty()){
                    session.setAttribute("pwd",userpwd);
                }

                session.setMaxInactiveInterval(30); // session의 유효 기간 설정 30초

            }else{
                session.setAttribute("loggedInUser",userid);

                if(userpwd != null && !userpwd.isEmpty()){
                    session.setAttribute("pwd",userpwd);
                }

                session.setMaxInactiveInterval(30);
            }
        }

        doGet(req, resp);
    }
}
