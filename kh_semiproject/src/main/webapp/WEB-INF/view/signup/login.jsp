<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인</title>
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
        text-align: center;
    }
    form{
        position: absolute;
        font-size: 25px;
        height: 400px;
        width: 800px;
        left: 100px;
        border: 1px solid black;
    }
    input{
        height: 30px;
        width: 220px;
    }
    th{
        text-align: left;
    }
    table{
        position: absolute;
        top: 50px;
        left: 200px;
    }
    .IdInfo{
        position:fixed;
        left: 700px;
        top: 190px;
    }
    .PassInfo{
        position:fixed;
        left: 700px;
        top: 230px;
    }
    button{
        position: absolute;
        bottom: 200px;
        left: 306px;
        font-weight: bold;
        font-size: 20px;
        height: 40px;
        width: 80px;
        background-color: gray;
        color: black;
        border: none;
        font-size: 20px;
    }
    a{
        position: absolute;
        bottom: 270px;
        right: 365px;
        width: 110px;
        height: 40px;
        text-align: center;
        line-height: 40px;
        background-color: gray;
        color: black;
        font-weight: bold;
        text-decoration-line: none;
        font-size: 21px;
    }
    </style>
</head>
<body>
    <body>
        <div class="title">
            <p>커뮤니티 사이트</p>
        </div>
        <div class="IdInfo"><p>영어,숫자만 가능</p></div>
        <div class="PassInfo"><p>10자이상 대소문자,숫자포함</p></div>
        <div class="login">
            <h2>로그인</h2>
            <form action="${request.getContextPath()}/semi/login" method="post">  
                <table>
                    <tr>
                        <th>아이디</th>    
                        <td><input type="text" name="id" required></td>  
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td><input type="text" name="password" required></td>
                    </tr>
                </table>
                <button type="submit">확인</button>
            </form>
            <a href="${request.getContextPath()}/semi/signup">회원가입</a> 
        </div>
        <div class="footer">
            <p>copyright (c) 백의헌 게시판만들기</p>
        </div>
</body>
</html>