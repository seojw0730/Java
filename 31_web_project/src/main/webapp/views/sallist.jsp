<%@page import="kh.mclass.jdbc.model.vo.Salgrade"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>샐그레이드 리스트</title>
</head>
<body>
<%=request.getAttribute("volist") %>
<br><br>
<%
List<Salgrade> volist = (List<Salgrade>)request.getAttribute("volist");
for(Salgrade vo : volist){
%>
<%=vo.getGrade() %> | <%=vo.getLosal() %> | <%=vo.getHisal() %>
<br>
<%
}
%>
<br><br>
${volist.get(0).grade } | ${volist.get(0).losal } | ${volist.get(0).hisal }<br>
${volist.get(1).grade } | ${volist.get(1).losal } | ${volist.get(1).hisal }<br>
${volist.get(2).grade } | ${volist.get(2).losal } | ${volist.get(2).hisal }<br>
${volist.get(3).grade } | ${volist.get(3).losal } | ${volist.get(3).hisal }
</body>
</html>