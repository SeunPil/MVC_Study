package com.spring.mvc.api;

import com.spring.mvc.board.domain.Board;
import com.spring.mvc.board.service.BoardService;
import com.spring.mvc.common.paging.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/v1")
public class ApiControllerV1 {

    @GetMapping("/hello") // ## /api/v1/hello RequestMapping으로 인해 앞에 생략
    @ResponseBody // 클라이언트에게 순수 데이터 리턴 json
    // ResponseBody 전엔 404에러(주소를 찾을 수 없음)이 발생 하였는데 적용 후,
    // 리턴값인 "안녕"이 홈페이지에 나타남
    public String hello() {
        return "안녕";
    }

    @GetMapping("/hobby")
    @ResponseBody
    // ResponseBody로 인해 return에 적은 배열이 나타난다.
    public String[] hobby() {
        return new String[] {"음악", "축구", "꽃꽃이"};
    }

    @GetMapping("/major")
    @ResponseBody
    public List<String> major() {
        return Arrays.asList("정보보안", "컴퓨터공학", "수학과", "성악과");
    }

    // ResponseBody로 객체를 리턴 했을 때 Json이 클라이언트로 전송했을 때의 모습
    @GetMapping("article")
    @ResponseBody
    public Board board() {
        Board board = new Board();
        board.setBoardNo(600);
        board.setTitle("Json 제목");
        board.setContent("Json 테스트 중");
        board.setWriter("Json 작성자");
        return board;
    }

    //Json으로 인해 모든 클라이언트에게 같은 데이터 형식으로 전송된다.
    // 안드로이드 -> IOS
    // 자바 -> 파이썬 등 Json을 사용 해 전송하면 같은 모습으로 전송된다.

    @GetMapping("/food")
    @ResponseBody
    public Map<String, String> food() {

        // Map은 Key, Value로 값을 선언한다.
        // Map Study 자료 확인
        Map<String, String> foods = new HashMap<>();
        foods.put("한식", "육개장");
        foods.put("양식", "파스타");
        foods.put("중식", "탕수육");
        return foods;
    }

    @Autowired
    private BoardService boardService;

    @GetMapping("/b_list")
    @ResponseBody
    public List<Board> list() {
        // 1페이지의 20개의 글
        return boardService.getArticles(new Page(1, 20));
    }

    /*
        * 리턴 방식은 모두 동일하게 { } 대괄호 안에 정보들이 같은 방식으로 리턴된다.
    */


}
