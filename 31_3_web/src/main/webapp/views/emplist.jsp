<%@page import="java.util.List"%>
<%@page import="kh.mclass.jdbc.model.vo.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMP리스트</title>
</head>
<body>
<h1>사원 리스트</h1><br>
<%
List<Emp> volist = (List<Emp>)request.getAttribute("volist");
for(Emp vo : volist){
	%>
	사번: <%=vo.getEmpno() %>, 성명: <%=vo.getEname() %>, 직업: <%=vo.getJob() %>, 팀장 번호: <%=vo.getMgr() %>, 고용일자: <%=vo.getHiredate() %>, 급여: <%=vo.getSal() %>, 상여금: <%=vo.getComm() %>, 부서 번호: <%=vo.getDeptno() %><br>
	<%
}
%>
</body>
</html>