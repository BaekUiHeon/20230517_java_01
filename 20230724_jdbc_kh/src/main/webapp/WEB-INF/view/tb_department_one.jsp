<%@page import="kh.test.jdbckh.student.model.vo.DepartmentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%DepartmentVo vo = null;
	if(request.getAttribute("VO") instanceof DepartmentVo){
		vo = (DepartmentVo)request.getAttribute("VO");
	}%>
	<table border="1">
		<tr>
			<th>학과번호</th>
			<th>학과이름</th>
			<th>계열</th>
			<th>개설여부</th>
			<th>정원</th>
		</tr>
		<tr>
			<td><%=vo.getDepartmentNo() %></td>
			<td><%=vo.getDepartmentName() %></td>
			<td><%=vo.getCategory() %></td>
			<td><%=vo.getOpenYN() %></td>
			<td><%=vo.getCapacity() %></td>
		</tr>
	</table>
</body>
</html>