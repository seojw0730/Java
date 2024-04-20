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
<form id="frm-write" enctype="multipart/form-data">
	<div><label>제목</label><input type="text" name="title" required></div>
	<div><label>내용</label><textarea name="content" cols="50" required style="resize : none;"></textarea></div>
	<div><button type="button" class="btn file">파일추가</button></div>
	<!-- event click 시 추가 -->
	<div><button type="button" class="btn write">글쓰기</button></div>
</form>








<script>
$(loadedHandler);
function loadedHandler(){
	// event 등록
	$(".btn.write").on("click", btnWriteClkHandler);
	$(".btn.file").on("click", btnFileClkHandler);
}
function btnFileClkHandler(){
	var htmlVal = `<div><input type="file" name="uploadfiles"><button type="button" class="btn file-cancel">취소</button></div> `;
	$(this).parent().after(htmlVal); // append 맨 마지막 자식으로 추가
	
	// JS 중요함. Event 등록 시 중복 등록 방지
	$(".btn.file-cancel").off("click");
	$(".btn.file-cancel").on("click", btnFileCancelClkHandler);
}
function btnFileCancelClkHandler(){
	console.log("btnFileCancelClkHandler");
	$(this).parent().remove();
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
	// 중요!!
	var frm = document.getElementById("frm-write");
	frm.method = "post"; // content 가 길어서
	frm.action = "${pageContext.request.contextPath}/board/write";
	frm.enctype = "multipart/form-data"; // form 태그 내부에 input type="file" 이 있다면
	frm.submit();
}
</script>
</body>
</html>