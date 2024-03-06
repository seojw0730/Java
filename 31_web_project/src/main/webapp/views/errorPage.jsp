<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- import <%@ %> 안에 같이 있어도 됨, 가독성 좋게 따로 생김 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 위의 taglib 나중에 많이 쓸 예정 -->
<%
String ctxPath = request.getContextPath();
// 윗 줄과 같은 의미
pageContext.setAttribute("ctxPath", request.getContextPath());
pageContext.setAttribute("pageScope", "pageScope Value");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
<h1>${msg }</h1>
<br>
${ctxPath }
<br>
<%

 // response.getWriter() ==> out 이름의 객체
 out.write("aaa");
 // request.getSession() ==> session 이름의 객체
 session.setAttribute("loginId", "abc");
 // page ==> Object 현재 JSP를 class 의미로 봤을때 해당 JSP 객체 ex. class errorPage_jsp
 // pageContext ==> 외부 환경/설정 정보를 제공하는 객체
 // TODO: 예시
 
 // exception - TODO: 예시
 
 // 해당 페이지 내에서만 지정, 호출 가능
 String pcValue = (String)pageContext.getAttribute("pageScope");
%>

<%--
EL
${attribute명 } --> 좁은 범위부터 찾음
${request.getAttribute("attribute명") }
${session.getAttribute("attribute명") }
값 없으면 null이 아닌 ""로 나타남
 --%>
<c:choose>
 <c:when test="5!=6">화면에 바로 뿌려진다</c:when> <!-- if -->
 <c:when test=""></c:when> <!-- else if -->
 <c:when test=""></c:when> <!-- else if -->
 <c:otherwise></c:otherwise> <!-- else -->
</c:choose>
</body>
</html>