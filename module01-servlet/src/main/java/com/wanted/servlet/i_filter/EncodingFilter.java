package com.wanted.servlet.i_filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

/*comment
*  Filter는 Servlet Container에서 제공하는 특별한 기능이다.
*  HttpRequest, HttpResponse 가 발생할 때
*    가장 먼저  ,  가장 나중에   동작하는 기능이다.
*  Filter 를 적용하는 방식은 크게 2가지이다
*  1. XML 방식의 등록
*  2. 어노테이션 방식의 등록
* */

public class EncodingFilter implements Filter {
    // XML 방식의 필터 사용하기

    private String encodingType;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("encoding 필터의 init() 메서드 동작함 ");
        encodingType = filterConfig.getInitParameter("encoding-type");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        /*comment
        *  filter의 핵심 메서드로
        *  요청 및 응답 시 수행해야하는 알들을 해당 메서드에서 처리한다
        *  FilterChain은 다음 필터 혹은 필터가 더이상 없다면
        *  요청을 처리할 서블릿으로 향하게 된다  */

        response.setContentType(encodingType);
        // 다음 필터를 호출 or 없다면 Servlet 호출
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {
        System.out.println("encoding filter 파괴됨");
    }
}
