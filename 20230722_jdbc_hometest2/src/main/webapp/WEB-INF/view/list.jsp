<%@page import="home.test.jdbc.student.model.vo.StudentVo"%>
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
	<h2>집에서만들어볼게요</h2>
	<table border="1">
	<%List<StudentVo> list= (List<StudentVo>)request.getAttribute("StudentList");
	%>
		<tr>
			<td>학생번호</td>
			<td>이름</td>
			<td>주민등록번호</td>
		</tr>
		<%
		for(int i=0; i<list.size();i++){
			StudentVo vo=list.get(i);
		%>
		<tr>
			<td><%=vo.getStudentNo() %></td>
			<td><%=vo.getStudentName() %></td>
			<td><%=vo.getStudentSSN() %></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>