<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>	
<head>
<meta charset="EUC-KR">
<title>ȸ������</title>
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
    .signup{
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
        bottom: 20px;
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
        bottom: 90px;
        right: 150px;
        width: 80px;
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
	<c:if test="${alert==1}"> <%// ȸ������ ���п� ���� ��¹��� %>
	<script>
    function showAlert() {
        alert('��й�ȣ�� �ٸ��ϴ�');
    }
    showAlert();
	</script>
	</c:if>
	<c:if test="${alert==2}">
	<script>
    function showAlert() {
        alert('ȸ������ ����');
    }
    showAlert();
	</script>
	</c:if>
	
	
    <div class="title">
        <p>Ŀ�´�Ƽ ����Ʈ</p>
    </div>
    <div class="IdInfo"><p>����,���ڸ� ����</p></div>
    <div class="PassInfo"><p>10���̻� ��ҹ���,��������</p></div>
    <div class="signup">
        <h2>ȸ������</h2>
        <form action="${request.getContextPath()}/semi/signup" method="post"> <!--�ּ� �Է����־����-->
            <table>
                <tr>
                    <th>���̵�</th>    
                    <td><input type="text"  name="id" pattern="[A-Za-z0-9]+" required></td>  
                </tr>
                <tr>
                    <th>��й�ȣ</th>
                    <td><input type="password"  name="password1" pattern="^(?=.*[a-z])(?=.*[A-Z]).{10,}$" required></td>
                </tr>
                <tr>
                    <th>��й�ȣȮ��</th>
                    <td><input type="password"  name="password2" pattern="^(?=.*[a-z])(?=.*[A-Z]).{10,}$" required></td>
                </tr>
                <tr>
                    <th>�г���</th>
                    <td><input type="text"  name="writer"></td>
                </tr>
                <tr>
                    <th>�̸���</th>
                    <td><input type="text"  name="emailAddress" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}"></td>
                </tr>
            </table>
            <button type="submit">Ȯ��</button>
        </form>
    </div>
    <div><a href="${request.getContextPath()}/semi/login">�α���</a></div>
    <div class="footer">
        <p>copyright (c) ������ �Խ��Ǹ����</p>
    </div>
</body>
</html>