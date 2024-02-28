<%@page import="kh.mclass.jdbc.model.vo.Dept"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept List</title>
</head>
<body>
	Dept List 한글 테스트
	<br> ${data1 }
	<br> ${data2 }
	<br>
	<%=request.getAttribute("data1")%>
	<br>
	<%
	List<Dept> volist = (List<Dept>) request.getAttribute("data1");
	String data2 = (String) request.getAttribute("data2");
	Integer data3 = (Integer) request.getAttribute("data3"); // return type = Object --> DownCasting
	for (Dept vo : volist) {
	%>
	<%=vo.getDeptno()%> | <%=vo.getDname()%> | <%=vo.getLoc()%>
	<br>
	<%
	}
	%>
	<h1>EL (Expression Language 표현언어로 표현만 가능. for, if 등 제어문 없음.)</h1>
	<br> ${data1.get(0).deptno } | ${data1.get(0).dname } |	${data1.get(0).loc }
</body>
</html>