package com.wanted.servlet.c_parameter.querystring;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (value = "/querystring")
public class QueryStringServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet 메서드 호출됨");
        String name = req.getParameter("name");
        System.out.println("name = " + name);
        
//      url 로 넘어오는 데이터는 모두 String으로 따라서 우리가 원하는 타입으로 받아오기 위해선 형변환을 해줘야한다
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("age = " + age);
    }
//    get 방식은 입력한 값들이 url에 노출됨
//    http://localhost:8080/querystring?name=%EC%9E%84%EC%88%98%EC%98%81&age=23&birthday=2026-03-03&gender=F&national=ko&hobbies=sleep
//    사용자가 요청을 보내면 요청과 관련된 모든 정보는 HttpServletRequest에 담겨있다


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
