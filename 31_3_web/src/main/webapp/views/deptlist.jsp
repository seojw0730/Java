<%@page import="kh.mclass.jdbc.model.vo.Dept"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept 리스트</title>
</head>
<body>
	<h1>부서 리스트</h1>
	<%
	List<Dept> volist = (List<Dept>) request.getAttribute("volist");
	for (Dept vo : volist) {
	%>
	부서 번호:
	<%=vo.getDeptno()%>, 부서명:
	<%=vo.getDname()%>, 부서 위치:
	<%=vo.getLoc()%><br>
	<%
	}
	%>
	<h1>부서 추가</h1>
	<div>
		<form method="post" action="http://127.0.0.1:8080/home/dept/insert"
			target="_self" autocomplete="off">
			<table>
				<tr>
					<td>
						<div>
							<input type="checkbox">deptno:
						</div>
					</td>
					<td>
						<div>
							<input type="text" name="deptno">
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div>
							<input type="checkbox">dname:
						</div>
					</td>
					<td>
						<div>
							<input type="text" name="dname">
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div>
							<input type="checkbox">loc:
						</div>
					</td>
					<td>
						<div>
							<input type="text" name="loc">
						</div>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="확인"> <input
						type="reset" value="Clear"></td>
				</tr>
			</table>
		</form>
	</div>
	<h1>부서 삭제</h1>
	<div>
		<form method="post" action="<%=request.getContextPath()%>/dept/delete"
			target="_self" autocomplete="off">
			<div>
				<div>
					<input type="checkbox">deptno: <input type="text"
						name="deptno">
				</div>
			</div>
			<span> &nbsp;&nbsp;&nbsp;&nbsp; <input type="submit"
				value="확인"> <input type="reset" value="Clear">
			</span>
		</form>
	</div>
</body>
</html>