<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시글목록</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
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
        	<input type="button" value="좋아요:${countLike}" class="like">
            <p>제목:${vo.subject}</p>
            <div>
                <p>작성자:${vo.writer}</p>
                <p>작성일:${vo.wdate}</p>
            </div>
            <div class=content1>
                <p>내용:${vo.content}</p>
            </div>
            
	        <div>
                <p>댓글</p>
            </div>
            <table>
            <c:forEach items="${commentlist}" var="item">
                <tr>
                	<c:forEach begin="0" end="${item.depth - 1}" varStatus="loop">
            			<td></td>
        			</c:forEach>
                    <td>${item.writer }: ${item.content }</td>
                    <c:if test="${mid!=item.id}">
                    <td><input type="button" id="writecomment" value="댓글달기"></td>
                    </c:if>
                    <c:if test="${mid==item.id}">
                    <td><input type="button" id="deletecomment" value="삭제"></td>
                    </c:if>
                </tr>
                </c:forEach>
            </table> 
        </div>
        <c:if test="${mid!=vo.id}">
        <div class="comment">
            <p>댓글작성</p>
            <input type="text" id="comment">
            <input type="button" value="작성완료">
        </div>
        </c:if>
        <nav>
            <a href="<%=request.getContextPath()%>/list">목록</a> 
            <c:if test="${mid == vo.id}"> 
            <a href="<%=request.getContextPath()%>/write?idx=${vo.idx}&content=${vo.content}&subject=${vo.subject}">수정</a>
            </c:if>
            <a href="<%=request.getContextPath()%>/write">작성</a>
        </nav>
        <div class="footer">
            <p>copyright (c) 백의헌 게시판만들기</p>
        </div>
        <script>
        	$(".like").click(update_like);
        	function update_like(){
        	$.ajax({
        		url: "${pageContext.request.getContextPath()}/getlike",
        		data:{idx:"${vo.idx}",mid:"${mid}"},
        		type:"get",
        		success:getlike
        	});
        	}
        	function getlike(result) {
        	    $(".like").val("좋아요:" + result);
        	}
        	
          	$(".comment input[type=button]").click(insertcomment)
        	function insertcomment(){
          		console.log("insertcomment");
        		var comment= $("#comment").val();
        		$.ajax({
        			url:"${pageContext.request.contextPath}/insertcomment",
        			data:{content:comment, idx:"${vo.idx}"},
        			type:"get",
        			dataType:"Json",
        			success:getcomment
        		}
        		);
        	}
          	
          	function getcomment(data) {
          	    var commentlist = data.commentlist;
          	    var table = $("<table></table>"); // 테이블 태그 생성

          	    $.each(commentlist, function(index, item) {
          	        var row = $("<tr></tr>");

          	        for (var i = 0; i < item.depth; i++) {
          	            $("<td></td>").appendTo(row);
          	        }

          	        $("<td>" + item.writer + ":" + item.content + "</td>").appendTo(row);
          	        if ("${mid}" != item.id) {
          	            $("<td><input type='button' value='댓글달기' id='writecomment'></td>").appendTo(row);
          	        } else {
          	            $("<td><input type='button' value='삭제' id='deletecomment'></td>").appendTo(row);
          	        }
          	        row.appendTo(table);
          	    });

          	    $("table").replaceWith(table);
          	}   	 
          	
            $("#writecomment").click(writeboard)
            function writeboard(){
            	var html = $("<tr>"
            				+"<td><input type='text'><td>"+"<td><input type='button' class='writeboard' value='작성'></td>"
            				+"</tr>");
            	$(this).closest('tr').after(html);
            } 
            
            
	       $(".writeboard").click(write_comment_comment)
            function write_comment_comment(){
            $.ajax({
           	}
            );
       		}
	       
      </script>
</body>
</html>

