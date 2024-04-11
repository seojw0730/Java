<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html lang="ko">
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
<h1>Semim Join</h1>
<form action="${pageContext.request.contextPath }/join" method="post">
<div>아이디:<input type="text" name="id" autocomplete=off><button type="button" class="btn checkid">중복확인</button></div>
<div>패스워드:<input type="password" name="pwd" autocomplete=off></div>
<div>이메일:<input type="text" name="email" autocomplete=off></div>
<div>이름:<input type="text" name="name" autocomplete=off></div>
<div><button type="submit">회원가입</button></div>
</form>
<div class="member-list">
	
</div>



















<script>
$(loadedHandler);
function loadedHandler(){
	// event 등록
	$(".btn.checkid").on("click", btnCheckidClkHandler);
}

function btnCheckidClkHandler(){
	var idVal = $("[name=id]").val();
	$.ajax({
		url : "${pageContext.request.contextPath }/checkid"
		// , async : false // true - 비동기, false - 동기
		, method : "post"
		, data : {id : idVal, k1 : "v1", k2 : "v2"} // --> contentType
		// data 자료형은 contentType 이라 부름
		
		
		
		
		// dataType 은 위의 data와는 무관, 밑의 result의 자료형을 바꿔달라는 것
		// , dataType : "int"
		, success : function(result){ // --> dataType, 매개변수 기본적으로 String 으로 인식
			console.log(typeof result);
			// [{}, {}]
			if(result > 0){
				alert("중복된 아이디 존재");
			}else {
				alert("사용가능한 아이디");
			}
			
			
			
			
			
			/*
			console.log(typeof result);
			var htmlVal = '';
			$.each(result, function(){
				console.log(this.memEmail);
				console.log(this);
				// 백틱도 가능
				// htmlVal += '<div>' + this.memEmail + '</div>';
			});
			$(".member-list").html(htmlVal);
			*/
			
			
		}
		, error : function(request, status, error){
			alert("code : " + request.status + "\n" + "message : " + request.responseText + "\n"
					+ "error : " + error);
		}
		// , async : true/false 등등
	});
}
</script>
</body>
</html>