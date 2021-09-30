<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!-- JSTL -->
<% @taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>

    <h1>회원가입에 성공했습니다!</h1>
    <h2>${user.userName}님 환영합니다!</h2>

    <div>
        # 아이디: ${user.userId} <br>
        # 비밀번호: ${user.userPw} <br>
        <!-- private 필드인데 가능 한 이유 -->
        <!-- Getter가 존재하면 private필드도 자동으로 변환 돼(getuserName) 사용 가능하다. -->
        # 이름: ${user.userName} <br>
        # 나이: ${user.userAge}<br>
        # 취미: ${user.hobbies} <br>
        <ul>
            <!-- hobbies라는 배열에 있는 정보를 hobby에 담아 li로 출력 -->
            <c:ForEach var="hobby" items="${user.hobbies}">
            <li>${hobby}</li>
        </c:ForEach>

        </ul>
    </div>

</body>

</html>