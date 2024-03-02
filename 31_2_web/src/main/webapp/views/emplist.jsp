<%@page import="kh.mclass.jdbc.model.vo.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Emp 리스트</title>
</head>
<body>
<h1>한글</h1>
	<%-- <h6>${volist }</h6> --%>
	<%
	List<Emp> volist = (List<Emp>) request.getAttribute("volist");
	for (Emp vo : volist) {
	%>
	사원 번호: <%=vo.getEmpno()%>, 
	이름: <%=vo.getEname()%>, 
	직무: <%=vo.getJob()%>, 
	팀장 번호: <%=vo.getMgr()%>, 
	봉급: <%=vo.getSal()%>, 
	상여금: <%=vo.getComm()%>, 
	부서 번호: <%=vo.getDeptno()%>
	<br>
	<%
	}
	%>
</body>
</html>