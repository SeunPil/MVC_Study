package com.spring.mvc.board.repository;
// resources 패키지에 위와 같은 경로를 한번 더 만들어줘야 함

import com.spring.mvc.board.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    //1. 게시물 목록 조회
    List<Board> getArticles();

    //2. 게시물 상세 조회 (글 내용보기)
    //글 번호를 전달 받아야 그 안에 상세 내용 조회 가능
    Board getContent(int boardNo);

    //3. 게시물 등록
    //등록을 위해 작성자, 내용 등등을 입력 받기 위해 Board를 모두 전달한다.
    boolean insertArticle(Board board);

    //4. 게시물 삭제
    //게시물 삭제를 위해 글 번호를 전달 받아야함.
    boolean deleteArticle(int boardNo);

    //5. 게시물 수정
    //게시물 수정을 위해 글 내용은 ~로 수정하고 제목은 ~을 수정하기 위해 Board를 전달받는다.
    boolean modifyAritcle(Board board);

}
