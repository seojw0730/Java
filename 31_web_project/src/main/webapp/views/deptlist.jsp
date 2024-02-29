<%@page import="kh.mclass.jdbc.model.vo.Dept"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%!
int sum(int a, int b){
	return a+b;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept List</title>
</head>
<body>
	Dept List 한글 테스트
	<br> ${data2 }
	<br> ${data3 }
	<br>
	<%
	List<Dept> volist = (List<Dept>) request.getAttribute("volist");
	String data2 = (String) request.getAttribute("data2");
	Integer data3 = (Integer) request.getAttribute("data3"); // return type = Object --> DownCasting
	if (volist != null) {
		if (volist.size() == 0) {
	%>
	DEPT 데이터가 없습니다.
	<%
	} else {

	for (Dept vo : volist) {
	%>

	<%=vo.getDeptno()%>
	|
	<%=vo.getDname()%>
	|
	<%=vo.getLoc()%>
	<br>
	<%
	}
	}
	} else {
	%>
	시스템이 불안정하여 잠시후 다시 확인해주세요.
	<%
	}
	%>
	<h1>
		<!-- EL (Expression Language 표현언어로 표현만 가능. for, if 등 제어문 없음.) -->
	</h1>
	<c:forEach begin="1" end="10" step="3" var="i">
	${i } 
	</c:forEach>
	
	<c:if test="${empty volist }">
	시스템이 불안정하여 잠시후 다시 확인해주세요.
	</c:if>
	<c:choose>
		<c:when test="${empty volist }">
		시스템이 불안정하여 잠시후 다시 확인해주세요.
		</c:when>
		<c:when test="${volist.size() == 0 }">
		DEPT데이터가 없습니다.
		</c:when>
		<c:otherwise>
			<c:forEach items="${volist }" var="vo" varStatus="vs">
			부서번호: ${vo.deptno }, 부서명: ${vo.dname }, 지역: ${vo.loc }, ${vs.index }, ${vs.count } <br>  
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<br>
	<c:forEach items="${volist }" var="vo">
	${vo.deptno } | ${vo.dname } | ${vo.loc }<br>
	</c:forEach>
	<br>
	<%-- ${volist.get(0).deptno } | ${volist.get(0).dname } | ${volist.get(0).loc } --%>
</body>
</html>