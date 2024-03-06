<%@page import="kh.mclass.jdbc.model.vo.Salgrade"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등급 단일 조회</title>
</head>
<body>
<h1>등급 단일 조회</h1><br>
<%
Salgrade vo = (Salgrade)request.getAttribute("vo");
%>
등급: <%=vo.getGrade() %>, Losal: <%=vo.getLosal() %>, Hisal: <%=vo.getHisal() %>
</body>
</html>