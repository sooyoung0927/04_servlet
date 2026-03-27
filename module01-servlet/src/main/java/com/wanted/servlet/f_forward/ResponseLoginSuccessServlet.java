package com.wanted.servlet.f_forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print")
public class ResponseLoginSuccessServlet extends HttpServlet {
    // 사용자에게 응답을 해주는 역할

    // 요청을 post로 받았기 때문에 응답도 post 방식으로
    /*comment
    *  forward에서 받은 서블릿에서도 요청 방식이 get이면 doGet
    *  post 이면 doPost로 오버라이딩 한디*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_id = req.getAttribute("user_id").toString();
        // Attribute는 키-벨류 형태로 값을 저장 (객체 형태)
        System.out.println("전달받은 사용자 아이디 : "+user_id);

        StringBuilder responseText = new StringBuilder();
        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h3 align=\"center\">")
                .append(user_id)
                .append("님 환영합니다.</h3>")
                .append("</body>\n")
                .append("</html>\n");

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.print(responseText.toString());

        out.flush();
        out.close();

    }
}
