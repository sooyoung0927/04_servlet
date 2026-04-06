<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2026-03-30
  Time: 오전 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Session 결과 재확인</h1>
<h3>
  <%
  //Java 코드를 입력할 수 있는 영역
    String loggedInUser = (String) session.getAttribute("loggedInUser");
  %>
  <%=
    loggedInUser
  %>
</h3>
</body>
</html>
