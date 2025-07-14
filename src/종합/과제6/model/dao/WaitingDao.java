package 종합.과제6.model.dao;

import 종합.과제6.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingDao {
    // 1) 싱글톤
    private WaitingDao(){}
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance(){
        return instance;
    }
    // 2) DTO 저장할 리스트 선언
    private ArrayList<WaitingDto> waitingDB = new ArrayList<>();

    // 3) 등록 기능 구현
    public boolean addWaiting( String phone, int count ){
        boolean result = false;
        // 1. 매개변수 값들을 객체화하기
        WaitingDto waitingDto = new WaitingDto( phone , count );
        // 2. 리스트(DB)에 생성한 객체 대입하기
        waitingDB.add(waitingDto);
        // 3. 성공시 result에 성공의 의미 ture 대입
        result = true;
        return result;
    }

    // 4) 전체조회 기능 구현
    public ArrayList< WaitingDto > getWaitingList(){
        return waitingDB;
    }
}
