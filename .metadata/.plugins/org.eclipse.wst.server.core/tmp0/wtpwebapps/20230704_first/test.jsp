<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <!-- style 지정 - 각자 실습- -->
    <!---->
    <script>
        $(loadedHandler); // loadedHandler라는 함수를, body의 document가 모두 구성된후 실행함.
         
        function loadedHandler(){ //loadedHandler함수선언시작.
            $('.c').on("blur",cntBlurHandler);  // class="c"를 가진선택자는 blur(해당텍스트위치를 벗어날때)가 일어날때 cntBlurHandler를 실행함. 
            $("[type=button]").on("click",calcClickHandler); // button타입이 클릭될때 calcClickHandler를 실행함.
        } // 함수선언끝.

        function cntBlurHandler(event){  //cntBlurHandler함수선언시작.
            // console.log(this);
            // console.log(event.target);
            // console.log(event);
            var cost = $(this).parent().prev().text();  //현재 선택자의 부모의, 형제중이전선택자, 의텍스트를, cost에 저장
            var count = $(this).val(); //현재 선택자의 값을 count에 저장. 
            $(this).parent().next().children(".p").val(cost * count); //현재 선택자의 부모의, 형제중다음선택자, 의자식중p클래스를가진, 것의값을(cost*count)로 만듬.
        }
        function calcClickHandler(event){  // calcClickHandler함수선언시작
            console.log(this);
            console.log(event.target);
            console.log(event);
            var sum=0; //sum값 초기화.
            $("#cTotalCnt").val(0); //cTotlaCnt값 초기화.
            $(".c").each(function(){ // class="c"를 가진값들을 모두 더하여 sum에저장
                sum += parseInt($(this).val());
            });
            $("#cTotalCnt").val(sum); //sum값을 cTotlaCnt에 저장

            sum=0; //sum값 초기화
            $("#cTotalPrice").val(0); //cTotalPrice값 초기화
            $(".p").each(function(){ //class="p"를 가진 값들을 모두 더하여 sum에 저장
                sum+= parseInt($(this).val());
            });
            $("#cTotalPrice").val(sum); //cTotlaPrice에 sum을 저장.
    }
    </script>
</head>
<body>
    <form>
    <table border="1">
        <tr>
            <th>메뉴</th>
            <th>가격</th>
            <th>수량</th>
            <th>합계</th>
        </tr>
        <tr>
            <td>아메리카노</td>
            <td>2500</td>
            <td><input type="text" name="c1" id="c1" class="c"></td>
            <td><input type="text" name="c1Price" id="c1Price" class="p" readonly></td>
        </tr>
        <tr>
            <td>라떼</td>
            <td>3000</td>
            <td><input type="text" name="c2" id="c2" class="c"></td>
            <td><input type="text" name="c2Price" id="c2Price" class="p" readonly></td>
        </tr>
        <tr>
            <td>생강라떼</td>
            <td>4500</td>
            <td><input type="text" name="c3" id="c3" class="c"></td>
            <td><input type="text" name="c3Price" id="c3Price" class="p" readonly></td>
        </tr>
        <tr>
            <th>합계</th>
            <th></th>
            <th><input type="text" name="cTotalCnt" id="cTotalCnt" class="c" readonly></th>
            <th><input type="text" name="cTotalPrice" id="cTotalPrice" class="p" readonly></th>
        </tr>
        <tr>
            <td colspan="4">
                <input type="button" value="계산하기">
                <input type="reset" >
            </td>
        </tr>
    </table>
</form>
</body>
</html>