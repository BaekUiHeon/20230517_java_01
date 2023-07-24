<%@page import="java.util.ArrayList"%>
<%@page import="kh.test.jdbckh.student.model.vo.DepartmentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과목록</title>
</head>
<body>
<h2> 학과목록 </h2>

<%List<DepartmentVo> list=(ArrayList<DepartmentVo>)request.getAttribute("dplist"); %>
<table border="1">
		<tr border="1">
			<th>학과번호</th>
			<th>학과이름</th>
			<th>계열</th>
			<th>개설여부</th>
			<th>정원</th>
		</tr>
		<%for(int i=0;i<list.size();i++){ 
			DepartmentVo vo=list.get(i);
		%>
		<tr>
			<td><a href="<%=request.getContextPath()%>/onedepartment?deptno=<%=vo.getDepartmentNo()%>"><%=vo.getDepartmentNo()%></a></td>
			<td><%=vo.getDepartmentName() %></td>
			<td><%=vo.getCategory() %></td>
			<td><%=vo.getOpenYN() %></td>
			<td><%=vo.getCapacity() %></td>
		</tr>
		<%
		} 
		%>
</table>
</body>
</html>