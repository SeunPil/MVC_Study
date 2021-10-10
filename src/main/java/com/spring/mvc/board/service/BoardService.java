package com.spring.mvc.board.service;

import com.spring.mvc.board.domain.Board;
import com.spring.mvc.board.repository.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//스프링에서 관리할 수 있도록 설정
@Service
//구현체가 1개면 사용
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    //게시물 목록 가져오기
    public List<Board> getArticles() {
        List<Board> articles = boardMapper.getArticles();

        //3분 이내 신규 글에 new마크 표시하기

        //모든 글을 확인해 3분안에 작성된 글인지 확인하기
        for (Board article : articles) {
            //각 게시물들의 등록시간을 읽어오기(밀리초 getTime)
            long regTime = article.getRegDate().getTime();

            //현재시간 읽어오기(밀리초)
            long now = System.currentTimeMillis();
            // 3분 ( 60초 * 3분 * 1000ms
            if (now - regTime < 60 * 3 * 1000 ) {
                article.setNewFlag(true);
            }
            //현재 조회수 가져오기
            int viewCnt = article.getViewCnt();
            System.out.println("viewCnt = " + viewCnt);
            System.out.println("article.isBestFlag() = " + article.isBestFlag());
            if ( viewCnt > 10 ) {
                article.setBestFlag(true);
            }

        }

        return articles;
    }

    //게시글 상세조회
    //자동 롤백
    @Transactional
    public Board getContent(int boardNo) {
        Board content = boardMapper.getContent(boardNo);
        //상세조회를 했을 때 조회수 Up
        boardMapper.upViewCount(boardNo);

        return content;
    }

    //게시물 작성
    public Boolean insert(Board board) {
        boolean insert = boardMapper.insertArticle(board);
        return insert;
    }

    //게시물 삭제
    public boolean remove(int boardNo) {
        return boardMapper.deleteArticle(boardNo);
    }

    //게시물 수정
    public boolean modify(Board board) {
        return boardMapper.modifyArticle(board);
    }




}
