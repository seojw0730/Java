<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
function checkLogin(msg, prePage){
	// 로그인 페이지로 이동
	var ssLogin = "${ssLogin}"; // EL 은 "" 안에 작성되어 blank 상황에 문법적 오류 방지
	if(!ssLogin){ // "" 가 false 이기 때문에 이렇게도 씀(false : NaN, undefined, 0, "")
		var result = confirm(msg);
		if(result){
			location.href="${pageContext.request.contextPath}/login?prePage=" + prePage;
			return true;
		}else{
			// ----
		}
		// TODO return true;
		return false;
	}
	return false;
}

</script>