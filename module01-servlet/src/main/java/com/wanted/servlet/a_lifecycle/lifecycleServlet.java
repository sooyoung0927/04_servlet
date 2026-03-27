package com.wanted.servlet.a_lifecycle;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

/*comment
*  @WebServlet 어노테이션은 해당 클래스가 Servlet임을 명시하는 어노테이션이다
*  value 속성은 서블릿이 매핑 될 url 패턴을 지정하며
*  해당 클래스는 /life-cycle 요청이 들어오면 처리한다 */

@WebServlet(value = "/life-cycle")
public class lifecycleServlet extends HttpServlet {

    private int initCount =1;
    private  int serviceCount =1;
    private int destroyCount =1;

    public lifecycleServlet() {
        System.out.println("<기본 생성자 호출됨>");
    }

    @Override // 최초 동작 시
    public void init(ServletConfig config) throws ServletException {
        System.out.println("<init 호출됨>"+initCount++);
    }

    @Override // 호출 시
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("<service 호출됨>"+serviceCount++);
    }

    @Override // 서버 종료 시
    public void destroy() {
        System.out.println("<destroy 호출됨>"+destroyCount++);
    }
}
