<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kh.mclass.jdbc.model.vo.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Emp List</title>
</head>
<body>
	Emp List 이엠피
	<br>
	<br>
	<%=request.getAttribute("data1")%>
	<br>
	${data1 }
	<br>
	<%
	List<Emp> list = (List<Emp>) request.getAttribute("data1");
	for (Emp vo : list) {
	%>
	<%=vo.getEmpno() %> | <%=vo.getEname() %> | <%=vo.getSal() %>
	<br>
	<%
	}
	%>
	<br>
	${data1.get(0).empno } | ${data1.get(0).ename } | ${data1.get(0).job }
	<br>
	<br> ${data2 }
</body>
</html>