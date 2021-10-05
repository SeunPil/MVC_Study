package com.spring.mvc.score.repository;

import com.spring.mvc.score.domain.Score;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository("jr")
@Log4j2
public class JdbcScoreRepository implements ScoreRepository {

    //DB접속정보 설정
    private String userId = "spring3";
    private String userPw = "1234";
    private String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
    private String driver = "oracle.jdbc.driver.OracleDriver";

    @Override
    public void save(Score score) {

    }

    @Override
    public List<Score> findAll() {
        List<Score> scoreList = new ArrayList<>();

        try {
            //1. 드라이버 로딩
            Class.forName(driver);

            //2. 연결정보 객체 생성
            Connection conn = DriverManager.getConnection(dbUrl, userId, userPw);

            //3. SQL실행 객체 생성
            String sql = "SELECT * FROM score";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            //4. SQL실행
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) scoreList.add(new Score(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return scoreList;
    }

    @Override
    public Score findOne(int stuNum) {
        return null;
    }

    @Override
    public void remove(int stuNum) {

    }
}
