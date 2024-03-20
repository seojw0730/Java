<%@page import="kh.mclass.jdbc.model.vo.Salgrade"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salgrade 리스트</title>
</head>
<body>
<h1>급여 등급 리스트</h1>
<%
List<Salgrade> volist = (List<Salgrade>)request.getAttribute("volist");
for(Salgrade vo : volist){
	%>
급여 등급: <%=vo.getGrade() %>, Losal: <%=vo.getLosal() %>, Hisal: <%=vo.getHisal() %><br>	
	<%
}
%>
</body>
</html>