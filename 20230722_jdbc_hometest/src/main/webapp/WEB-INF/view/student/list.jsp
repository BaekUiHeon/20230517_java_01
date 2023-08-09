<%@page import="home.test.jdbc.student.model.model.StudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>학생리스트</h2>
	<%
	List<StudentVo> volist=(List<StudentVo>)request.getAttribute("studentList");
	%>	
	<table border="1">
		<tr>
		<td>이름</td>
		<td>학생번호</td>
		<td>주소</td>
		</tr>
		<%for(int i=0; i<volist.size(); i++){
			StudentVo vo=volist.get(i);
			%>
		<tr>
		<td><%=vo.getStudentName() %></td>
		<td><%=vo.getStudentNo() %></td>
		<td><%=vo.getStudentAddress() %></td>
		</tr>
		<%
		} 
		%>
	</table>
</body>
</html>