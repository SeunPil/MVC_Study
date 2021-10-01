package com.spring.mvc.score.repository;

import com.spring.mvc.score.domain.Score;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//메모리에 성적정보들을 모아서 저장해야 한다.
//@Component와 같은 역할이지만 Repository의 역할이 명확해진다.

@Repository // 스프링 저장소에 Bean으로 등록
@Log4j2
public class MemoryScoreRepository implements ScoreRepository {

    //데이터베이스 역할
    private static Map<Integer, Score> scoreMap = new HashMap<>();

    static {
        scoreMap.put(1, new Score("김철수", 99, 66, 50));
        scoreMap.put(2, new Score("김나무", 69, 46, 56));
        scoreMap.put(3, new Score("김초록", 89, 56, 59));
    }

    @Override
    public void save(Score score) {
        score.calctotal();
        scoreMap.put(score.getStuNum(), score);
        log.info(scoreMap);
    }

    @Override
    public List<Score> findAll() {
        //Map에서 Score객체를 전부 뽑아낸 후 리스트에 담아 리턴
        List<Score> scores = new ArrayList<>();
        // Map은 : 포문 사용 불가지만 Keyset으로 키를 다 뽑아내면 value값 추출 가능
        for (int stuNum : scoreMap.keySet()) {
            // keySet으로 인해 뽑은 키를 get요청으로 value값을 뽑아 List scores에 등록한다.
            Score score = scoreMap.get(stuNum);
            scores.add(score);
        }
        return scores;
    }

    @Override
    public Score findOne(int stuNum) {
        return null;
    }

    @Override
    public void remove(int stuNum) {
        scoreMap.remove(stuNum);
    }
}
