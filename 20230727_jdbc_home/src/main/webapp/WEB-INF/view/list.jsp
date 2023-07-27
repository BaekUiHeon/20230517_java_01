<%@page import="home.student.model.vo.StudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생리스트</title>
</head>
<body>
	<h2>학생리스트</h2>
	<div><a href="<%=request.getContextPath()%>/student/insert">학생등록</a></div>
	
	<div>
		<form action="<%=request.getContextPath()%>/student/list" method="get">
			<input type="text" name="searchWord">
			<button type="submit">찾기</button>
		</form>
	</div>
	
	<%List<StudentVo> volist=(List<StudentVo>)request.getAttribute("studentList");%>
	<%String searchWord=(String)request.getAttribute("searchWord");%>
	
	<%if(searchWord!=null){ %>
		<h3><%=searchWord%> 검색결과</h3>
		<h5><a href="<%=request.getContextPath()%>/student/list">전체보기</a></h5>
		
	<%}if(volist!=null && volist.size()==0){%>
	<h3>결과물이 없습니다.</h3><%} else{	%>
		
		<table border="1">											<%//하나라도 있다면 리스트를 띄운다. %>
		<tr>
			<td>학번</td>
			<td>이름</td>
			<td>입학일</td>
			<td>주소</td>
		</tr>
		<%}for(int i=0;i<volist.size();i++){
		StudentVo vo=volist.get(i);
		%>
		<tr>
			<td><%=vo.getStudentNo()%></td>
			<td><%=vo.getStudentName()%></td>
			<td><%=vo.getEntranceDate()%></td>
			<td><%=vo.getStudentAddress()%></td>
			<%} %>
		</tr>
		</table>
		<%
		int startPageNum=(int)request.getAttribute("startPageNum");
		int endPageNum=(int)request.getAttribute("endPageNum");
		int currentPage=(int)request.getAttribute("currentPage");
		int totalPageNum=(int)request.getAttribute("totalPageNum");
		
		if(startPageNum!=1 && searchWord!=null){
			%>
			<a href="<%=request.getContextPath()%>/student/list?pageNo=<%=startPageNum-1%>&searchWord=<%=searchWord%>"><span>이전</span></a>
		<%}else if(startPageNum !=1 && searchWord==null){
		%>
		<a href="<%=request.getContextPath()%>/student/list?pageNo=<%=startPageNum-1%>"><span>이전</span></a>
		<%} %>
		<%
		if(searchWord!=null){
		for(int i=startPageNum; i<=endPageNum; i++){ %>
		<a href="<%=request.getContextPath()%>/student/list?pageNo=<%=i%>&searchWord=<%=searchWord%>"><%=i%></a>
		<%} }else{ 
			for(int i=startPageNum; i<=endPageNum; i++){
		%>
		<a href="<%=request.getContextPath()%>/student/list?pageNo=<%=i%>"><span><%=i%></span></a>
		,
		<%}} %>
		
		<%if(endPageNum<totalPageNum && searchWord!=null){
			%>
			<a href="<%=request.getContextPath()%>/student/list?pageNo=<%=endPageNum+1%>&searchWord=<%=searchWord%>">다음</a>
		<%} else if(endPageNum<totalPageNum  &&  searchWord==null){ %>
		<a href="<%=request.getContextPath()%>/student/list?pageNo=<%=endPageNum+1%>">다음</a>
		<%} %>
</body>
</html>