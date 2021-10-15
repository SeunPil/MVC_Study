package com.spring.mvc.reply.api;

import com.spring.mvc.reply.domain.Reply;
import com.spring.mvc.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 비동기 통신

@RestController
@RequestMapping("/api/v1/reply")
@Log4j2
@RequiredArgsConstructor
public class ReplyApiController {

    private final ReplyService replyService;

    // 댓글 목록 조회 요청 처리
    @GetMapping("/{boardNo}")
    //@PathVariable은 경로를 읽어다가 매개변수에 넣어준다.
    public ResponseEntity<List<Reply>> list(
            @PathVariable int boardNo) {
        log.info("/api/v1/reply/" + boardNo + " GET!");
        //서비스에게 댓글 목록 요청
        List<Reply> replyList = replyService.getList(boardNo);

        return new ResponseEntity<>(replyList, HttpStatus.OK);
    }

}