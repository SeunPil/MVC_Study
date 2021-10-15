package com.spring.mvc.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @ResponseBody 자동 주입
@RequestMapping("/api/v2")
public class ApiControllerV2 {

/*
                #ResponseEntity
                - 스프링 REST API가 응답 할 때
                응답 데이터 뿐만 아니라 응답 상태 코드 (404,400,500 등등) 응답 헤더 등을
                조작해서 전송할 수 있게 해주는 객체
                비동기 통신이라고 불린다.

                동기 통신:  화면 새로고침이 이루어진다.
                비동기 통신: 화면 새로고침이 이루어지지 않으면서 단독적으로 요청을 수행한다.

                즉 댓글은 동영상 시청 중 댓글을 작성하면 시청하던 동영상은 새로고침이 되면 안되므로
                댓글만 따로 비동기 통신으로 단독적으로 수행하게 만든다 이걸 가능하게 하는것이 REST API이다.
*/

    @GetMapping("/hello")
    public ResponseEntity<String> hello(String p) {
        if (p.equals("hi")) {
            return new ResponseEntity<String>("나도 안녕~", HttpStatus.OK); // OK 200번
        } else
            return new ResponseEntity<String>("인사 해줘", HttpStatus.INTERNAL_SERVER_ERROR); // 코드 오류 500번
    }

}
