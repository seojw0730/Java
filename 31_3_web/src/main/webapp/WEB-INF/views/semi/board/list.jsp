<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Semim Board List</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<jsp:include page="/WEB-INF/views/semi/common_function.jsp"/>
<style>
ul {
list-style-type:none;
}
ul > li {
display: inline-block;
padding: 0 10px;
}
table{
border-collapse: collapse;
text-align: center;
margin: 0 auto;
}
td{
border: 1px solid black;
}
.board{
width: max-content;
margin: 0 auto;
}
.board.write{
float:left;
}
.board.list{
clear: both;
}
.board.pageNum{
text-align: center;
}
</style>
</head>
<body>
[[ 로그인 정보 : ${ssLogin} ]]<br>
[[ map : ${map.dtolist }]]<br>
[[ totalPageCount : ${map.totalPageCount }]]<br>
[[ startPageNum : ${map.startPageNum }]]<br>
[[ endPageNum : ${map.endPageNum }]]<br>
<h1>Semim Board List</h1>

<div class="board">
<div class="board write"><button type="button" class="btn write" >글쓰기</button></div>

<div class="board list">
<c:choose>
	<c:when test="${empty map.dtolist }">
	글 없어요.
	</c:when>
	<c:otherwise>
	<table>
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>작성시간</td>
			<td>작성자</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${map.dtolist }" var="vo" varStatus="vs">
		<tr>
			<td><div>${vo.boardId }</div></td>
			<td><div><a href="${pageContext.request.contextPath }/board/read?id=${vo.boardId }">${vo.title }</a></div></td>
			<td><div>${vo.writeTime }</div></td>
			<td><div>${vo.boardWriter }</div></td>
			<td><div>${vo.readCount }</div></td>
		</tr>
		</c:forEach>
	</table>
	</c:otherwise>
</c:choose>
</div>

<div class="board pageNum">
	<ul>
	<c:if test="${map.startPageNum > 1}">
		<li><a href="${pageContext.request.contextPath }/board/list?page=${page = 1}"> &lt;&lt; </a></li>
        <li><a href="${pageContext.request.contextPath }/board/list?page=${map.startPageNum-1 }"> &lt; </a></li>
	</c:if>
	<c:forEach begin="${map.startPageNum }" end="${map.endPageNum }" var="page">
		<c:if test="${map.currentPageNum == page }">
		<li><strong>${page }</strong></li>
		</c:if>
		<c:if test="${map.currentPageNum != page }">
		<li><a href="${pageContext.request.contextPath }/board/list?page=${page }">${page }</a></li>
		</c:if>
	</c:forEach>
	<c:if test="${map.endPageNum < map.totalPageCount }">
		<li><a href="${pageContext.request.contextPath }/board/list?page=${map.endPageNum + 1 }"> &gt; </a>
        <li><a href="${pageContext.request.contextPath }/board/list?page=${page = map.totalPageCount}"> &gt;&gt; </a>
	</c:if>
	</ul>
</div>
</div>

<script>
$(loadedHandler);
function loadedHandler(){
	//event 등록
	$(".btn.write").on("click", btnWriteClickHandler);
}

function btnWriteClickHandler(){
	//Login 페이지로 이동
	if(checkLogin("로그인되어야 글쓰기가 가능합니다.\n로그인페이지로 이동하시겠습니까?","write")){
		location.href="${pageContext.request.contextPath}/login?prePage=write";
		return;
	}
	location.href="${pageContext.request.contextPath}/board/write";
}
</script>
</html>