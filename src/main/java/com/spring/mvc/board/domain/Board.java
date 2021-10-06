package com.spring.mvc.board.domain;

import lombok.*;

import java.util.Date;

@Setter @Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    private int boardNo; // 글 번호
    private String writer; // 작성자
    private String title; // 글 제목
    private String content; // 글 내용
    private int viewCnt; // 조회수
    private Date regDate; // 글 작성 시간


}

// 기본 작성 후 SQL TABLE 생성