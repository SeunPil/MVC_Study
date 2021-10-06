package com.spring.mvc.score.repository;
// Spring

import com.spring.mvc.score.domain.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //마이바티스 SQL처리 인터페이스
public interface ScoreMapper {

    //마이바티스는 클래스를 인터페이스 내부에서 만들고 XML 파일로 정보를 전달해줘야한다.
    //XML 파일은 인터페이스 이름과 똑같이 생성하고 .xml 파일로 생성해줘야한다.
    //resources 폴더에 package com.spring.mvc.score.repository 경로를 그대로 하나 더 생성해야 함.


    //점수 저장 기능
    void save(Score score);

    //전체 점수 정보 조회기능
    List<Score> findAll();

    //개별 점수 정보 조회기능
    Score findOne(int stuNum);

    //점수 정보 삭제 기능
    void remove(int stuNum);
}
