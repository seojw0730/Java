<%@page import="kh.mclass.jdbc.model.vo.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 단일 조회</title>
</head>
<body>
<h1>사원 단일 조회</h1>
<%Emp vo = (Emp)request.getAttribute("vo"); %>
사번: <%=vo.getEmpno() %>, 성명: <%=vo.getEname() %>, 직업: <%=vo.getJob() %>, 팀장 번호: <%=vo.getMgr() %>, 고용일자: <%=vo.getHiredate() %>, 급여: <%=vo.getSal() %>, 상여금: <%=vo.getComm() %>, 부서 번호: <%=vo.getDeptno() %><br>
</body>
</html>