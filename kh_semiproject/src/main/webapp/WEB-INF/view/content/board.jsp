<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시글목록</title>
    <style>
    body{
        position: relative;
        width: 1000px;
        min-height: 600px;
        border: 1px solid black;
    }
    .title{
        font-weight: bold;
        width: 800px;
        height: 50px;
        border: 1px solid black;
        margin: 5px auto;
        text-align: center;
    }
    .content{
        width: 800px;
        min-height: 200px;
        border: 1px solid black;
        margin: 5px auto;
    }
    p{
        display: inline-block;
    }
    .comment{
        position: relative;
        left: 100px;
    }
    input[type=submit]{
        height: 27px;
        font-weight: bold;
        color: black;
    }
    input[type=text]{
        width: 715px;
        height: 20px;
    }
    nav{
        position: absolute;
        bottom: 60px;
        right: 100px;
    }
    nav a{
        display: inline-block;
        background-color: gray;
        width: 80px;
        height: 40px;
        text-align: center;
        line-height: 40px;
        font-weight: bold;
        font-size: 20px;
        color: black;
        text-decoration: none;
    }
    .footer{
        position: absolute;
        bottom: 0px;
        left: 99px;
        width: 800px;
        height: 50px;
        border: 1px solid black;
        margin: 5px auto;
        text-align: center;
    }
    .content1{
    	width: 600px;
    }
    .like{
        display: inline-block;
        position: absolute;
        right: 200px;
        top: 100px;
        text-align: center;
        line-height: 40px;
        font-weight: bold;
        width: 120px;
        height: 40px;
        font-size: 20px;
        background-color: gray;
        color: black;
        text-decoration: none;
    }
    </style>
</head>
<body>
    <body>
        <div class="title">
            <p>커뮤니티 사이트</p>
        </div>
        <div class="content">
        <%//게시글번호(idx),(접속계정)id받아와야함 %>
        	<a href="${request.getContextPath()}/list.board?idx=${idx}&id=${id}" class="like">좋아요 ${count}</a> 
            <p>제목:${subject}</p>
            <div>
                <p>작성자:${writer}</p>
                <p>작성일:${wDATE}</p>
            </div>
            <div class=content1>
                <p>내용:${content}</p>
            </div>
            <div>
                <p>댓글 조회</p>
            </div>
            <table>
            <c:forEach items=${commentList var="item" }>
                <tr>
                    <td>${item.writer }: ${item.content }</td>
                    <c:if test="${writer==item.writer}"><%//writer 동일하다면 나오게 코드구현해야함%>
                    <td><a href="${request.getContextPath()}/semi/board?deletecommentitem=item">삭제</a></td>
                    </c:if>
                </tr>
                </c:forEach>
            </table>
        </div>
        <div class="comment">
            <p>댓글작성</p>
            <form action="${request.getContextPath()}/semi/board" method="get"> 
            	<input type="hidden" name="id" value="${id}"> <%//접속된 계정정보를 가지고 가져가는 부분 추가구현필요  %>
                <input type="text" name="comment">
                <input type="submit" value="작성완료">
            </form>
        </div>
        <nav>
            <a href="${request.getContextPath()}/semi/list?id=id">목록</a> 
            <c:if test="${1==1}"> <%//접속 계정에따른 조건문추가해야함 %>
            <a href="${request.getContextPath()}/semi/write?content=${content}&subject=${subject}&id=${id}">수정</a> 
            </c:if>
            <a href="${request.getContextPath()}/semi/write?id=id">작성</a>
        </nav>
        <div class="footer">
            <p>copyright (c) 백의헌 게시판만들기</p>
        </div>
</body>
</html>