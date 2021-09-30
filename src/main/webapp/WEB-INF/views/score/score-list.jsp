<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>성적관리 프로그램</title>

    <style>
        label {
            display: block;
        }

        .score-list > li {
            margin-bottom: 10px;
        }
        .score-list > li:first-child {
            font-size: 1.2em;
            color: blue;
            font-weight: 700;
            border-bottom: 1px solid skyblue;
        }
        
    </style>
</head>


<h1>시험 점수 등록</h1>
<form action="#" method="POST"></form>
<label for="">
    # 이름: <input type="text" name="name">
</label>
<label for="">
    # 국어: <input type="text" name="kor">
</label>
<label for="">
    # 영어: <input type="text" name="eng">
</label>
<label for="">
    # 수학: <input type="text" name="mat">
</label>
<label for="">
    <button type="submit">확인</button>
    <button id="go-home" type="button">홈 화면으로</button>
</label>
</form>

<hr>
<ul class="score-list">
    <li>총 학생 수: XXX명</li>
    
    <c:ForEach></c:ForEach>
    <li>
        # 학번: , 이름: , 국어: , 영어: , 수학: , 총점: , 평균:
    </li>



</ul>


<script>
    const home = document.getElementById('go-home');
    home.addEventListener('click', e => {
        location.href = '/'; // 링크이동가능
    });
</script>


</body>

</html>