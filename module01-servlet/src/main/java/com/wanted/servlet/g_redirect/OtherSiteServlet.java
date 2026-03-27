package com.wanted.servlet.g_redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet ("/othersite")
public class OtherSiteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get 요청 수락함");
        System.out.println(resp);
        /*comment
        *  sendRedirect 를 하게 되면, network 탭을 확인했을 때 302 코드와 함께 다른 사이트로 이동한다
        *  redirect는 사용자 url 재작성이라고 불리우며 강제로 사용자의 url을 변경하여
        *  경로를 이동시키는 역할을 하게 된다 */
        resp.sendRedirect("https://www.naver.com");
    }
}
