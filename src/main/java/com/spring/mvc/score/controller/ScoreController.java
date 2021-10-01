package com.spring.mvc.score.controller;

import com.spring.mvc.score.domain.Score;
import com.spring.mvc.score.repository.ScoreRepository;
import com.spring.mvc.score.service.ScoreService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.PublicKey;
import java.util.List;

@Controller
@Log4j2

@RequiredArgsConstructor    // final필드를 초기화하는 생성자 자동생성
// 주석처리된 부분을 자동 생성 해준다.

//     public ScoreController(ScoreRepository scoreRepository)
//        this.scoreRepository = scoreRepository;

public class ScoreController {

    private final ScoreRepository scoreRepository;
    private final ScoreService scoreService;


    //점수프로그램 화면요청
    @GetMapping("/score/list")
    public String scoreList(Model model) {
        List<Score> scores = scoreRepository.findAll();
        log.info(scores);
        model.addAttribute("scoreList", scores);
        return "score/score-list";
    }

    //점수정보 저장 요청
    //Post인 이유 : form태그가 POST로 받아왔기 때문
    @PostMapping("/score/register")
    public String register(Score score) {
        // 점수 저장
        scoreService.register(score);
        // 리다이렉트는 재요청 기능이다.
        return "redirect:/score/list";
    }

    //점수정보 삭제 요청처리
    @GetMapping("/score/delete")
    public String delete(int stuNum) {
        log.info("점수 삭제 요청! - ");
        scoreRepository.remove(stuNum);
        return "redirect:/score/list";
    }

}