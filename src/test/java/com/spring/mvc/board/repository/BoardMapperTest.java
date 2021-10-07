package com.spring.mvc.board.repository;

import com.spring.mvc.board.domain.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//테스트시에 스프링 컨테이너를 사용한다.
@SpringBootTest
class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;

    @Test
    @DisplayName("300개의 게시물을 등록해야 한다.")
    void bulkInsert() {
        for (int i = 1; i <= 300; i++) {
            Board board = new Board();
            board.setTitle("테스트 제목 " + i);
            board.setContent("테스트내용 " + i);
            board.setWriter("USER" + i);

            boardMapper.insertArticle(board);
        }
        System.out.println("게시물 등록 성공!!");
    }

    @Test
    @DisplayName("전체 게시물을 글번호 내림차순으로 조회해야 한다.")
    void selectAll() {
        List<Board> articles = boardMapper.getArticles();

        for (Board article : articles) {
            System.out.println(article);
        }
        Assertions.assertTrue(articles.size() == 300);
    }

    @Test
    @DisplayName("글번호를 통해 1개의 게시물을 상세 조회해야 한다.")
    void SelectOne() {
        Board content = boardMapper.getContent(30);

        assertEquals("USER30", content.getWriter());
    }

    @Test
    @DisplayName("글번호를 통해 게시물을 1개 삭제해야 한다.")
    @Transactional
    @Rollback
    void delete() {
        boolean result = boardMapper.deleteArticle(300);
        Board content = boardMapper.getContent(300);
        assertTrue(result);
        assertNull(content);
    }

    @Test
    @DisplayName("글번호를 통해 게시물의 제목과 내용을 수정해야 한다.")
    void modify() {
        // 수정 할 글 번호와, 제목, 수정 내용을 생성자를 생성한 후 Set으로 입력해준다.
        Board board = new Board();
        board.setBoardNo(50);
        board.setTitle("수정");
        board.setContent("수정 할 내용");
        // boardMapper의 modifyArticle에 set으로 값을 준 생성자를 입력해준다.
        boolean result = boardMapper.modifyArticle(board);
        Board content = boardMapper.getContent(50);

        // 난 result의 값이 true 될 것을 테스트를 통해 기대한다.
        assertTrue(result);
        // content = 50번 글
        // 50번 글의 제목(getTitle)이 "수정"일 것을 기대한다.
        assertEquals("수정", content.getTitle());
    }

}