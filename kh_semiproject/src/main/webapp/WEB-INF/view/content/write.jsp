<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
    .title{
        font-weight: bold;
        width: 800px;
        height: 50px;
        border: 1px solid black;
        margin: 5px auto;
        text-align: center;
    }
     body{
        position: relative;
        width: 1000px;
        height: 600px;
        border: 1px solid black;
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
    form{
        position: absolute;
        left: 100px;
        width: 800px;
        height: 400px;
        border: 1px solid black;
    }
    table{
        margin: 20px auto;
    }
    .col1{
        width: 40px;
        font-size: 20px;
    }
    .col1{
        width: 40px;
    }
    input[type="text"]{
        width: 494px;
    }
    textarea{
        height: 270px;
        width: 494px
    }
    input[type=submit]{
        position: relative;
        top: 13px;
        left: 720px;
        background-color: gray;
        border: none;
        width: 80px;
        height: 40px;
        text-align: center;
        line-height: 40px;
        font-weight: bold;
        font-size: 20px;
        color: black;
    }
    .list{
        display: inline-block;
        position: relative;
        top: 415px;
        left: 730px;
        background-color: gray;
        border: none;
        width: 80px;
        height: 40px;
        text-align: center;
        line-height: 40px;
        font-weight: bold;
        font-size: 20px;
        color: black;
        text-decoration: none;
    }
    .title2{
        position: relative;
        left: 350px;
    }
    </style>
</head>
<body>
    <div class="title">
        <p>커뮤니티 사이트</p>
    </div>
    <form action="${request.getContextPath()}/semi/write.do" method="get">
    	<td class="title2">게시물 작성</td>
        <table>
            <tr>
                <td class="col1">제목</td>
                <td class="cols2"><input type="text" name="subject" <c:if test="${subject!=null}">value="${subject}"</c:if>></td>
            </tr>
            <tr>
                <td class="col1">내용</td>
                <td class="cols2"><textarea name=content <c:if test="${content!=null}">value="${content}"</c:if>></textarea></td>
            </tr>
        </table>
        <input type="hidden" name="idx" value="${idx}"> <%//idx값이 존재한다면... 수정함수를 호출하도록 writecontroller에서 작성해야함 %>
        <input type="submit" value="완료">
    </form>
    <div>
        <a href="${request.getContextPath()}/semi/list" class="list">목록</a>
    </div>
    <div class="footer">
        <p>copyright (c) 백의헌 게시판만들기</p>
    </div>
</body>
</html>