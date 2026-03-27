package com.wanted.servlet.d_response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (value = "/response")
public class ResponseServlet extends HttpServlet {

//    a태그 쓰면 무조건 doGet 호출
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*comment
        *  Servlet의 역힐
        *  1. 요청 받기 - Http method GET/POST 요청에 따라 parameter로 전달받은 데이터를 꺼내올 수 있다
        *  2. 비즈니스 로직 처리 - Servlet 은 사용자의 요청이 오면 최조에 동작을 한다
        *  -> MVC의 Controller 역할을 하며 Service 계층으로 전달하는 역할을 할 수 있다
        *  3. 응답하기 - Requset 로 요청을 전달받은 후 Response객체를 활용해서 사용자에게 응답을 할 수 있다  */

        /*comment
        *  1단계에서는 한글이 깨진다
        *  */

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>\n")
                       .append("<html>\n")
                       .append("<head>\n")
                       .append("</head>\n")
                       .append("<body>\n")
                       .append("<h1>안녕~~</h1>\n")
                       .append("</body>\n")
                       .append("</html>\n");

        /*comment
        *  서버에서 보내주는 데이터 형태와 화면에서 보여주는 데이터 형태가 맞지 않아 한글이 깨진다 */
        System.out.println("response type : "+ resp.getContentType());


        resp.setContentType("text/html; charset=UTF-8");

        // 화면에 노출시키는 객체
        PrintWriter out = resp.getWriter();
        out.print(responseBuilder);
        out.flush();
        out.close();
    }
}
