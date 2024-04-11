<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html lang="ko">
<html>
<head>
<meta charset="UTF-8">
<title>Semi Login</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
<h1>Semi Login</h1>
<!-- 일반적인 form -->
<fieldset>
	<legend>로그인 form</legend>
	<form action="${pageContext.request.contextPath }/login" method="post">
		<div><label>아이디</label><input type="text" name="id" autocomplete="off"></div>
		<div><label>패스워드</label><input type="password" name="pwd" autocomplete="off"></div>
		<div><input type="submit" value="로그인"></div>
	</form>
</fieldset>


<!-- ajax -->
<fieldset>
	<legend>로그인 ajax</legend>
	<form id="frm-login">
		<div><label>아이디</label><input type="text" name="id" autocomplete="off"></div>
		<div><label>패스워드</label><input type="password" name="pwd" autocomplete="off"></div>
		<div><input type="button" value="로그인" class="btn submit"></div>
	</form>
</fieldset>

<script>
$(loadedHandler);
function loadedHandler(){
	//event 등록
	$("#frm-login .btn.submit").on("click", frmClickHandler);
}

function frmClickHandler(){
	console.log("submit?");
	// console.log(document.getElementById("frm-login").serialize());
	console.log($("#frm-login").serialize()); // id=aaa&pwd=aaa
	
	$.ajax({
		url : "${pageContext.request.contextPath }/login"
		, method : "post"
		, data : $("#frm-login").serialize()
		// serialize --> query string(name : value)형태로 나열해줌_{id : $("[name=id]").val(), pwd : $("[name=pwd]").val()}
		, success : function(result){
			console.log(result);
			if(result == 1){
				alert("반갑습니다.");
				var prePage = "${prePage}";
				if(prePage == "write"){
					location.href = "${pageContext.request.contextPath}/board/write";
				}
				location.href = "${pageContext.request.contextPath}/main";
			}else{
				alert("아이디 또는 패스워드가 일치하지 않습니다.\n다시 입력해주세요.");
				$("[name=pwd]").val("");
			}
		}
		, error : function(request, status, error){
			alert("code : " + request.status + "\n" + "message : " + request.responseText + "\n"
					+ "error : " + error);
		}
	});
	
}
</script>
































</body>
</html>