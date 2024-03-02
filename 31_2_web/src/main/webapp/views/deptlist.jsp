<%@page import="java.util.List"%>
<%@page import="kh.mclass.jdbc.model.vo.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept 리스트</title>
</head>
<body>
<h1>한글</h1>
	<%
	List<Dept> volist = (List<Dept>) request.getAttribute("volist");
	for (Dept vo : volist) {
	%>
	부서 번호: <%=vo.getDeptno()%>, 
	부서명: <%=vo.getDname()%>, 
	부서 위치: <%=vo.getLoc()%>
	<br>
	<%
	}
	%>
</body>
</html>