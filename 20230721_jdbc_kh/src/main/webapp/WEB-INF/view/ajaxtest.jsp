<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax test</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
.grid-wrap{
	display:grid;
	grid-template-columns:  auto auto;
}
</style>
</head>
<body>
<h2>ajax test</h2>
<input type="text">
<button id="btnajax1">ajax1</button>
<button id="btnajax2">ajax2</button>
<div class="grid-wrap">
<div>학과이름</div><div>계열</div>
</div>
<script>
$("#btnajax1").click(ajax1ClickHandler);    // 1번 버튼 클릭시 실행될 함수
$("#btnajax2").click(ajax2ClickHandler);	// 2번 버튼 클릭시 실행될 함수
function ajaxSuccess(result){				// ajax에 사용할 함수 선언 
	console.log("ctrl로부터 전달받은 데이터 :"); // 컨트롤러로 부터 받은 데이터를 콘솔에 출력할 생각임.
	console.log(result);
	alert(result);
}
function ajax1ClickHandler(){				// 1번 버튼 클릭시 실행될 함수에대한 정의 
	console.log("btnajax1 click");			
	//$.ajax(ojbect형태로매개인자전달해야함);
	//var obj = {k1:12, k2:'dskfjsdf', k3:function(){}};
	console.log("ajax로 데이터 전달 전-0");
	$.ajax({								// 이 함수가 실행되면 ajax도 실행됨. 그ajax에 대한 정의.
		url: "${pageContext.request.getContextPath}/ajax1"		// 이동할 url
		,type: "get"										// 보낼 type
		,data: {n1:'값도가나?', n2:123} 						// 이동할떄 가져갈 data
		,success: ajaxSuccess								// 값이 돌아왔을때 실행할 함수(인자1개)
	});
	console.log("ajax로 데이터 전달 중-1");
}
function ajax2ClickHandler(){				// 2번 버튼 클릭시 실행될 함수에대한 정의 
	console.log("btnajax2 click");
	$.ajax({
		url: "${pageContext.request.getContextPath}/ajax2"
		,type: "post"
		,success: ajaxSuccess2								//실행될 데이터 이름 ajaxSuccess2		
		,dataType:"json"									//여기서는 받을 datatype이 json임.
	});
}
function ajaxSuccess2(result){								//ajaxSuccess2에 대한 정의.
	console.log("2 ctrl로부터 전달받은 데이터 :");
	console.log(result);
	console.log(result.deptList);
	console.log(result.profList);
	console.log(result.endPage);
	console.log(result.startPage);
	if(result){												//Json으로 받은값(list)에서 해당컬럼이름별로 하나씩 꺼냄.
		for(var i=0; i<result.deptList.length;i++){
			var dvo = result.deptList[i];
			console.log(dvo.departmentName);				// 꺼낸값 출력.
		}	
	}
	
	displayDepartment(result.deptList);						// 웹에 출력하도록 하는 함수.
	
}
function displayDepartment(deptList){
	htmlVal = "	<div>학과이름</div><div>계열</div>";
	for(var i=0; i<deptList.length;i++){
		var dvo = deptList[i];
		htmlVal +="<div>"+dvo.departmentName+"</div>";
		htmlVal += "<div>"+dvo.category+"</div>";
	}
	$('.grid-wrap').html(htmlVal);	
}
</script>
</body>
</html>