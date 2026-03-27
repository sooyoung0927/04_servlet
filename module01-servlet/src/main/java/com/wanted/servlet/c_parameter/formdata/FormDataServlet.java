package com.wanted.servlet.c_parameter.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (value = "/formdata")
public class FormDataServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*comment
        *  get방식과 post 방식의 가장 큰 차이는 url로 데이터를 전달하는지에 대한 여부이다
        *  get방식은 url에 데이터가 노출,전달 되어 보안상 취약하다 다만 속도가 빨라 조회 시에 사용된다
        *  또한 url에 전달할 수 있는 데이터의 크기도 한정되어 있다
        *  post 방식은 url에 데이터가 노출되지 않고 사용자가 입력하는 데이터를 payload(body) 영역에 담아서 전달한다
        *  전달할 수 있는 데이터의 크기는 get 방식보다 훨씬 크다
        *  다만 속도가 느리기 때문에 딘순 조회 시에는 post 대신 get을 사용한다
        *  */

        String name = req.getParameter("name");
        System.out.println("name = " + name);
        
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("age = " + age);
    }
//    post 방식은 입력 값을 url에 노출하지 않음
//    http://localhost:8080/formdata
}
