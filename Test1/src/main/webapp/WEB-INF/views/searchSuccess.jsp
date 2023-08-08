<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	border: 1px solid black;
}
td{
	border: 1px solid black;
	text-align:center;
}
</style>
</head>
<body>
	<h2>회원정보</h2>
	<table>
		<tr>
		<td>회원정보</td>
		<td>회원아이디</td>
		<td>회원이름</td>
		<td>회원나이</td>
		</tr>
		<tr>
		<td>${vo.userNo}</td>
		<td>${vo.userId}</td>
		<td>${vo.userName}</td>
		<td>${vo.userAge}</td>
		</tr>
	</table>
	<a href="${request.getContextPath()}/test">메인페이지로 돌아가기</a>
</body>
</html>