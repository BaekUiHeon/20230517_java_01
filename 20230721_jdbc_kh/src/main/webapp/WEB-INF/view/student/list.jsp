<%@page import="kh.test.jdbckh.student.model.vo.StudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 리스트</title> 
</head>
<body>
	<h2>학생 리스트</h2>
	<div><a href="<%=request.getContextPath() %>/student/insert">학생등록</a></div> <%// 학생등록시 등록창으로 바로이동%> 
	<div>
		<form action="<%=request.getContextPath()%>/student/list" method="get">  <%//찾기창 누르면 serachWord가지고 list창으로 재이동%>
			<input type="search" name="searchWord">
			<input type="submit" value="찾기">
		</form>
	</div>
<%
// JSP Tag - java문법
List<StudentVo> volist = (List<StudentVo>)request.getAttribute("studentList"); //studentList는 무조건 들어와있는값이다.
String searchWord = (String)request.getAttribute("searchWord"); // searchWord는 있는경우와 없는경우가 있음.
if(searchWord != null){											// 있을경우 search검색결과와 전체보기를 띄운다.
%>
		<h3><%=searchWord %> 검색결과</h3>
		<h5><a href="<%=request.getContextPath() %>/student/list">전체보기</a></h5>
<%
}
if(volist == null || volist.size() == 0) { 						// 결과가 없다면 결과물이 없다고 띄운다.
//if(volist == null) {
//if (volist.size() == 0) {
%>
	<h2>결과물이 없습니다.</h2>
<%
} else {
%>
	<table border="1">											<%//하나라도 있다면 리스트를 띄운다. %>
		<tr>
			<td>학번</td>
			<td>이름</td>
			<td>입학일</td>
			<td>주소</td>
		</tr>
		<%
		for(int i=0; i<volist.size(); i++){
			StudentVo vo = volist.get(i);
		%>
		<tr>
			<td>
			<a href="<%=request.getContextPath()%>/student/get?sno=<%=vo.getStudentNo() %>">
			<%=vo.getStudentNo() %>
			</a></td>
			<td>
			<a href="<%=request.getContextPath()%>/student/get?sno=<%=vo.getStudentNo() %>">
			<%=vo.getStudentName() %>
			</a>
			</td>
			<td><%=vo.getEntranceDate() %></td>
			<td><%=vo.getStudentAddress() %></td>
		</tr>

		<%
		}  // for
		%>
	</table>
	<div>
	<%
	int startPageNum = (Integer)request.getAttribute("startPageNum"); // 페이징을 시작하면서 시작번호
	int endPageNum = (Integer)request.getAttribute("endPageNum");	  // 끝번호
	int currentPage = (Integer)request.getAttribute("currentPage");	  // 현재번호
	int totalPageNum = (Integer)request.getAttribute("totalPageNum"); // 총페이지번호가 항상 서블릿으로부터 입력된다.
	if(startPageNum != 1 && searchWord != null){									//시작번호가 1이아니면서 searchWord가 존재하면 
		%>
		<a href="<%=request.getContextPath()%>/student/list?pageNo=<%=startPageNum-1%>&searchWord=<%=searchWord%>"><span>이전</span></a> 
		,//searchWord를 유지하면서 pageNo를 시작번호-1로 변경함 
		<%
	} else if(startPageNum != 1 && searchWord == null) { 
		%>
		<a href="<%=request.getContextPath()%>/student/list?pageNo=<%=startPageNum-1%>"><span>이전</span></a>
		,<%//시작번호가 1이아니면서 searchWord없으면 pageNo를 시작번호-1로 변경만함.%>
		<%
	}
	
	for(int i=startPageNum;i<=endPageNum;i++){ // 시작번호부터 마지막번호까지 출력하는 반복문.
		if(searchWord != null){
//			if(currentPage == i){	}
		%>
		<a href="<%=request.getContextPath()%>/student/list?pageNo=<%=i%>&searchWord=<%=searchWord%>"><span><%=i%></span></a>
		,
		<%
		} else {
	%>
		<a href="<%=request.getContextPath()%>/student/list?pageNo=<%=i%>"><span><%=i%></span></a>
		,
	<%
		} // else
	}  // for
	if(endPageNum < totalPageNum  && searchWord != null){	// endpageNum이 totalpageNum보다 작을때만 다음을 보이게함, searWord가 존재할때 
		%>
		<a href="<%=request.getContextPath()%>/student/list?pageNo=<%=endPageNum+1%>&searchWord=<%=searchWord%>"><span>다음</span></a>
		,<%//searchWordl를 들고가라%>
		<%
	} else if(endPageNum < totalPageNum  && searchWord == null){
		%>
		<a href="<%=request.getContextPath()%>/student/list?pageNo=<%=endPageNum+1%>"><span>다음</span></a>
		,<%//searchWordl를 들고가지마라%>
		<%
	}
	%>
	</div>
<%
}  //else
%>
	
</body>
</html>