

## 스프링 MVC 첫 세팅
1. 우측 상단 gradle눌러서 새로고침 한번
2. src/main/resources폴더로 가서 application.properties 파일에
   `server.port = 8181`으로 수정
3. src/main/java에 MvcApplication클래스 main메서드 실행해서 서버띄우기
4. 한글 인코딩 필터 설정 (main/resources/application.properties)
```
# 서버 포트 변경
server.port = 8181

```

## 스프링 MVC 기본 설정
1. 뷰리졸버 등록
- 메인메서드가 있는 클래스 혹은 config클래스 (@Configuration)에 아래의 내용을 작성
```java
//뷰 리졸버 등록 : 컨트롤러가 리턴한 문자열을 가지고 뷰 파일을 포워딩해주는 객체
@Bean
public InternalResourceViewResolver viewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    return resolver;
}
```

2. 데이터베이스 설정
- C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib 에서 ojbc6.jar
- 아래 설정 경로 /WEB-INF/lib에 추가하기
```groovy
//database 관련 라이브러리 추가
//jdbc 라이브러리
implementation "org.springframework.boot:spring-boot-starter-jdbc"
//오라클 라이브러리 (11g edition - gradle, maven 라이센스 문제 공식 지원 불가)
implementation fileTree(dir: '/src/main/webapp/WEB-INF/lib', include: ['*.jar'])
```

- 스프링에게 DataSource정보 알려주기 (Hikari DataSource)
```java
//각종 설정 정보를 담을 클래스 (빈 등록)
@Configuration
@ComponentScan(basePackages = "com.spring.mvc")
public class RootConfig {

    //DB접속정보 DataSource 등록
    @Bean
    public DataSource dataSource() {

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        hikariConfig.setUsername("java_web1");
        hikariConfig.setPassword("202104");

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        return dataSource;
    }
}
```

## JSP 파일 템플릿
```jsp

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

</body>
</html>
```

## 여러가지 CSS를 가져와 사용할 수 있는 사이트

[사이트 이동] (https://getbootstrap.kr/)
```html
<!-- Bootstrap css cdn -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous">
</script>


<!-- Bootstrap JS cdn -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
    integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous">
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"
    integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous">
</script>

```

## 개인 노트 공간





## 크롬 확장 프로그램 설치
- JSON Viewer ( Json으로 리턴 된 값을 편하게 보여주는 것  )
- Boomerang - SOAP & REST Client

## HTTP Status
[사이트 이동] (https://developer.mozilla.org/ko/docs/Web/HTTP/Status)
- 200번, 201번, 400번, 404번, 405번, 500번
