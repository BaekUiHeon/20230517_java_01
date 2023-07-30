<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խñ۸��</title>
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
            <p>Ŀ�´�Ƽ ����Ʈ</p>
        </div>
        <div class="content">
        	<a href="#" class="like">���ƿ� ${count}</a>
            <p>����:${subject}</p>
            <div>
                <p>�ۼ���:${writer}</p>
                <p>�ۼ���:${wDATE}</p>
            </div>
            <div class=content1>
                <p>����:${content}</p>
            </div>
            <div>
                <p>��� ��ȸ</p>
            </div>
            <table>
            <c:forEach items=${commentList var="item" }>
                <tr>
                    <td>${item.writer }: ${item.content }</td>
                    <c:if test="${writer==item.writer}">
                    <td><a href="${request.getContextPath()}/semi/board?deletecommentitem=item">����</a></td>
                    </c:if>
                </tr>
                </c:forEach>
            </table>
        </div>
        <div class="comment">
            <p>����ۼ�</p>
            <form action="${request.getContextPath()}/semi/board" method="get"> 
            	<input type="hidden" name="id" value="${id}">
                <input type="text" name="comment">
                <input type="submit" value="�ۼ��Ϸ�">
            </form>
        </div>
        <nav>
            <a href="${request.getContextPath()}/semi/list?id=id">���</a> 
            <c:if test="">
            <a href="${request.getContextPath()}/semi/write?content=content&subject=subject&id=${id}">����</a> 
            </c:if>
            <a href="${request.getContextPath()}/semi/write?id=id">�ۼ�</a>
        </nav>
        <div class="footer">
            <p>copyright (c) ������ �Խ��Ǹ����</p>
        </div>
</body>
</html>