package com.spring.mvc;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class DBConnectTest {
    //Spring없이 java로만 db 연결하는 법
    //기본 설정 4가지

    //DB접속정보 설정
    private String userId = "hr";
    private String userPw = "hr";
    private String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
    //연결정보 생성 클래스
    private String driver = "oracle.jdbc.driver.OracleDriver";

    @Test
    void connectTest() {
        //1. 드라이버 클래스 동적 로딩
        try {
            Class.forName(driver);

            //2.연결 정보 생성
            Connection conn = DriverManager.getConnection(dbUrl, userId, userPw);
            System.out.println("db연결 성공!");

            String sql = "SELECT first_name FROM employees";
            //3. SQL 실행 객체 생성
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                //컬럼 읽는 명령어
                String name = rs.getString("first_name");
                System.out.println("name = " + name);

            }

        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 클래스를 찾을 수 없음");
        } catch (SQLException throwables) {
            System.out.println("SQL 에러!");
        }
    }
}
