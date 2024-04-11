<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>홈</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
[[${ssLogin }]]


<h1>Semim Main</h1>
<c:choose>
	<c:when test="${empty ssLogin }">
		<div><button class="btn join">회원가입</button></div>
		<div><button class="btn login">로그인</button></div>
	</c:when>
	<c:otherwise>
		<form id="frm-logout">
		<div><button class="btn logout">로그아웃</button></div>
		</form>
		<div><button class="btn mypage">마이페이지</button></div>
	</c:otherwise>
</c:choose>
<div><button class="btn board">게시판</button></div>












<script>
$(loadedHandler);
function loadedHandler(){
	// event 등록
	$(".btn.join").on("click", btnJoinClkHandler);
	$(".btn.login").on("click", btnLoginClkHandler);
	$(".btn.mypage").on("click", btnMypageClkHandler);
	$(".btn.board").on("click", btnBoardClkHandler);
	$(".btn.logout").on("click", btnLogoutClkHandler);
}

function btnJoinClkHandler(){
	// window.open("${pageContext.request.contextPath}/join", "_blank", "toolbar=yes, scrollbars=yes, resizable=no");
	location.href="${pageContext.request.contextPath}/join";
	// EL태그는 주석으로 막아도 동작할 수 있음
}

function btnLoginClkHandler(){
	location.href="${pageContext.request.contextPath}/login";
	
}

function btnMypageClkHandler(){
	location.href="${pageContext.request.contextPath}/mypage";
	
}

function btnBoardClkHandler(){
	location.href="${pageContext.request.contextPath}/board/list";
	
}

function btnLogoutClkHandler(){
	// get 방식 사용 X
	// location.href="${pageContext.request.contextPath}/logout";
	
	alert("로그아웃");
	
	// jQuery 보다 코드 간단
	var frmLogout = document.getElementById("frm-logout");
	frmLogout.action = "${pageContext.request.contextPath}/logout";
	frmLogout.method = "post";
	frmLogout.submit();
	
	
}
</script>
</body>
</html>