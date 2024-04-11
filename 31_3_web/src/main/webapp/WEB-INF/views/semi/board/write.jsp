<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Semim Board Write</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<jsp:include page="/WEB-INF/views/semi/common_function.jsp"/>
</head>
<body>
<h1>Semim Board Write</h1>
<form id="frm-write">
	<div><label>제목</label><input type="text" name="title" required></div>
	<div><label>내용</label><textarea name="content" rows="50" cols="50" required style="resize : none;">여기여기</textarea></div>
	<div><button type="button" class="btn write">글쓰기</button></div>
</form>








<script>
$(loadedHandler);
function loadedHandler(){
	// event 등록
	$(".btn.write").on("click", btnWriteClkHandler);
}
function btnWriteClkHandler(){
	
	// 로그인 페이지로 이동
	if(checkLogin("로그인되어야 글쓰기가 가능합니다. 로그인페이지로 이동하시겠습니까?", "write")){
		location.href = "${pageContext.request.contextPath}/login";
		return;	
	}
	
	
	// location.href="${pageContext.request.contextPath}/board/write";
	console.log($("[name=content]").val().length); // 사용자 입력값은 value가 진짜
	console.log($("[name=content]").val().trim().length);
	// console.log($("[name=content]").text());
	// textarea에서는 val() = 사용자 입력값도 포함 <---> html() = innerHTML 자리에 있는 문구만
	
	
	
	if($("[name=title]").val().trim().length == 0){
		alert("제목을 작성해주세요.");
		return;
	}
	if($("[name=content]").val().trim().length == 0){
		alert("내용을 작성해주세요.");
		return;
	}

	// <form>의 submit에 대한 코드
	var frm = document.getElementById("frm-write");
	frm.method = "post"; // content 가 길어서
	frm.action = "${pageContext.request.contextPath}/board/write";
	frm.submit();
}
</script>
</body>
</html>