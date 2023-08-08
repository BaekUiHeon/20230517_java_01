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
<% String searchWord=(String)request.getAttribute("searchWord");%>
<table border="1">
	<form action ="<%=request.getContextPath()%>/department">
		<input type="search" name="searchWord">
		<input type="submit" value="찾기">
		</form>
		<%if(searchWord!=null){%>
		<h3><%=searchWord%>검색결과</h3>
		<h3><a href="<%=request.getContextPath()%>/student/list">전체보기</a></h3>
		<%}%>
		<%if(list==null || list.size()==0){%>
		<h3>검색된 결과가 없습니다.</h3>
		<% }else{ %>
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
		<%}%>
</table>

</body>
</html>