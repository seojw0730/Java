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
<%=request.getAttribute("data1") %>
<br><br>
${data1 }
<br><br>
<%
List<Salgrade> volist = (List<Salgrade>)request.getAttribute("data1");
for(Salgrade vo : volist){
%>
<%=vo.getGrade() %> | <%=vo.getLosal() %> | <%=vo.getHisal() %>
<br>
<%
}
%>
<br><br>
${data1.get(0).grade } | ${data1.get(0).losal } | ${data1.get(0).hisal }<br>
${data1.get(1).grade } | ${data1.get(1).losal } | ${data1.get(1).hisal }<br>
${data1.get(2).grade } | ${data1.get(2).losal } | ${data1.get(2).hisal }<br>
${data1.get(3).grade } | ${data1.get(3).losal } | ${data1.get(3).hisal }
</body>
</html>