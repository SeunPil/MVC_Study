package com.spring.mvc.board.controller;

import com.spring.mvc.board.domain.Board;
import com.spring.mvc.board.repository.BoardMapper;
import com.spring.mvc.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/board")
//구현체가 1개면 사용
@RequiredArgsConstructor
//나는 Service에게 요청을 하고 일을 시킬 것이다.
public class BoardController {

    private final BoardService boardService;

    //게시물 목록 요청
    @GetMapping("/list")
    public String List(Model model) {
        log.info("/board/list GET 요청 발생! ");
        List<Board> articles = boardService.getArticles();
        //요청을 /board/list에 담아 나가기 위해 Model 사용
        model.addAttribute("articles", articles);
        return "/board/list";
    }

    //게시글 상세 보기
    @GetMapping("/content")
    public String Content(int boardNo, Model model) {
        log.info("요청 발생 " + boardNo);
        Board content = boardService.getContent(boardNo);
        model.addAttribute("content", content);
        return "/board/content";
    }
    //게시글 작성 화면을 띄워주기
    @GetMapping("/write")
    public String Write(Board board) {
        return "board/write";
    }

    @PostMapping("/write")
    // 작성자, 이름 , 내용을 받기 위해 Board
    public String write(Board board, RedirectAttributes ra) {
        log.info("/board/write POST 요청 !");
        //글 등록 실패 성공
        if(boardService.insert(board)) {
            //리다이렉트시 데이터 제거
            ra.addFlashAttribute("msg","success");
        } else {
            ra.addFlashAttribute("msg","fail");
        }
        return "redirect:/board/list";
    }

    @GetMapping("/delete")
    public String delete(int boardNo) {
        log.info("삭제 요청 전달 받음! " + boardNo);
        boardService.remove(boardNo);
        return "redirect:/board/list";
    }



}
