<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<div>
	<%--<form action="<%=request.getContextPath() %>/join" method="post">--%>
	<form id="frmJoin">
	<table>
	<tr>
	<th>아이디(5-9, 영문자로 시작,숫자,특수기호(_만가능)못씀)</th><td><input type="text" name="mid"></td></tr>
	<tr><th>패스워드(5-9, 대문자, 소문자, 숫자, 특수문자(!_#) 최소 1개이상 포함)</th><td><input type="password" name="mpwd"></td></tr>
	<th>이름(5-16)</th>	<td><input type="text" name="mname"></td></tr>
	<tr><th>전화번호(7-30)</th><td><input type="password" name="mtel"></td></tr>
	<th>이메일(5-100)</th>	<td><input type="text" name="memail"></td>	</tr>
	<tr><th>주민번호(14)</th>	<td><input type="password" name="msno"></td></tr>
	<tr><td colspan="2"><input type="button" value="회원가입"></td></tr>
	</table>
	</form>
	<%--  </form> --%>
	</div> 
	<script>
		$("#frmJoin [type=button]").click(sumbitHandler);
		function sumbitHandler(){
			console.log("여기 들어완?")
			var id=$("[name=mid]").val();
			var regEx_Id = /^[a-zA-Z][A-Za-z0-9]{4,8}$/;
			if(!regEx_Id.test(id)){
				alert("아이디는 5~16자 영문자로 시작하고 영문자와 숫자만 입력해주세요");
				$("[name=mid]").focus();
				return;
			}
			/* var pwd=$("[name=mpwd]").val();
			if(pwd.length<8 || pwd.length>20){
				alert("비밀번호는 8-20자 입력해주세요");
				$("[name=pwd]").focus();
				return;
			}	 */
			var pwd=$("[name=mpwd]").val();
			var regEx_Pwd=/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!_#])[a-zA-Z0-9!_#]{5,9}$/;
			if(!regEx_Pwd.test(pwd)){
				alert("패스워드는 5-9, 대문자, 소문자, 숫자, 특수문자(!_#) 최소 1개이상 포함");
				$("[name=mpwd]").focus();
				return;
		}
		}
	</script>
</body>
</html>