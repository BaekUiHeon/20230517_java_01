<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
 <title>����ȭ��</title>
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
    .login{
        position: absolute;
        bottom: 250px;
        left: 370px;
        width: 80px;
        height: 40px;
        text-align: center;
        line-height: 40px;
        background-color: gray;
    }
    .signup{
        position: absolute;
        bottom: 250px;
        left: 570px;
        width: 80px;
        height: 40px;
        text-align: center;
        line-height: 40px;
        background-color: gray;
    }
    a{
    text-decoration: none;
    }
    .login a{
        font-weight: bold;
        color: black;
    }
    .signup a{
        font-weight: bold;
        color: black;
    }
    </style>
</head>
<body>
    <div class="title">
        <p>Ŀ�´�Ƽ ����Ʈ</p>
    </div>
    <div class="login">
        <a href="${request.getContextPath()}/semi/login">�α���</a>
    </div>
    <div class="signup">
        <a href="${request.getContextPath()}/semi/signup">ȸ������</a>
    </div>
    <div class="footer">
        <p>copyright (c) ������ �Խ��Ǹ����</p>
    </div>
</body>
</html>