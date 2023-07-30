<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
    <title>�Խù� ���</title>
    <style>
    body{
        position: relative;
        width: 1000px;
        height: 600px;
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
    .list{
        width: 800px;
        height: 400px;
        border: 1px solid black;
        margin: 5px auto;
    }
    .list table{
        position: relative;
        bottom: 40px;
        border-spacing: 0;
        border-collapse: collapse;
        margin: 5px auto;
    }
    .list table th{
        font-size: 20px;
        padding: 0;
        box-sizing:content-box;
        border: 1px solid black;
        text-align: center;
    }
    .list table td{
        font-size:20px;
        padding: 0;
        margin: 0;
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
    .col1{
        width: 120px;
    }
    .col2{
        width: 120px;
    }
    .col3{
        width: 320px;
    }
    .col4{
        width: 220px;
    }
    .notice{
        position: relative;
        left: 10px;
    }
    .write{
        position: absolute;
        bottom: 150px;
        right: 120px;
        width: 80px;
        height: 40px;
        text-align: center;
        line-height: 40px;
        background-color: gray;
        font-weight: bold;
    }
    td{
    font-size: 20px; 
    padding: 0;
    box-sizing: content-box;
    border: 1px solid black;
    text-align: center;
    }
    .search{
        position:relative;
        left: 570px;
        bottom: 40px;
    }
</style>
</head>
<body>
        <div class="title">
            <p>Ŀ�´�Ƽ ����Ʈ</p>
        </div>
        <div class="list">
        <div class="notice"><p>�� ���� �Խù��� �ֽ��ϴ�</p></div>
        <span class="search">
            <form action ="${request.getContextPath()}/board/list" method="get">
                <input type="search" name="searchWord">
                <input type="submit" value="ã��">
            </form>
        </span>
            <table>
                <tr>
                	<th class="col1">��ȣ</th>
                    <th class="col2">�ۼ���</th>
                    <th class="col3">����</th>
                    <th class="col4">�ۼ���</th>   
                </tr>
                <c:forEach items="${list}" var="item">
                <tr> 
                    <td>${item.idx}</td>
                    <td>${item.writer}</td>
                    <td>${item.subject}</td>
                    <td>${item.wdate}</td>   
                </tr>
                </c:forEach>
                %>
            </table>
            <div class="write"><a href="${request.getContextPath()}/semi/write?id=id">�ۼ�</a></div>
        </div>
        <div class="footer">
            <p>copyright (c) ������ �Խ��Ǹ����</p>
        </div>
</body>
</html>