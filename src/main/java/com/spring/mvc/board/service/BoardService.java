package com.spring.mvc.board.service;

import com.spring.mvc.board.domain.Board;
import com.spring.mvc.board.repository.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

        return articles;
    }

    //게시물 상세 가져오기
    public Board getContent(int boardNo) {
        Board content = boardMapper.getContent(boardNo);
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



}
