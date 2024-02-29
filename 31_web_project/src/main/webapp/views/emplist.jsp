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
	<%=request.getAttribute("volist")%>
	<br>
	${volist }
	<br>
	<%
	List<Emp> list = (List<Emp>) request.getAttribute("volist");
	for (Emp vo : list) {
	%>
	<%=vo.getEmpno() %> | <%=vo.getEname() %> | <%=vo.getSal() %>
	<br>
	<%
	}
	%>
	<br>
	사번: ${volist.get(0).empno } | 성명: ${volist.get(0).ename } | 직업: ${volist.get(0).job }<br>
	사번: ${volist.get(1).empno } | 성명: ${volist.get(1).ename } | 직업: ${volist.get(1).job }<br>
	사번: ${volist.get(2).empno } | 성명: ${volist.get(2).ename } | 직업: ${volist.get(2).job }<br>
	사번: ${volist.get(3).empno } | 성명: ${volist.get(3).ename } | 직업: ${volist.get(3).job }<br>
	사번: ${volist.get(4).empno } | 성명: ${volist.get(4).ename } | 직업: ${volist.get(4).job }
	<br>
	<br> ${vacancy }
</body>
</html>