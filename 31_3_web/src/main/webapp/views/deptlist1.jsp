<%@page import="kh.mclass.jdbc.model.vo.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 단일 조회</title>
</head>
<body>
<h1>부서 단일 조회</h1><br>
<%
Dept vo = (Dept)request.getAttribute("vo");
%>
부서 번호: <%=vo.getDeptno() %>, 부서명: <%=vo.getDname() %>, 부서 위치: <%=vo.getLoc() %><br>

</body>
</html>