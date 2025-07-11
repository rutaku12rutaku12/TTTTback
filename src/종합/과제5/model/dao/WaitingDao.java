package 종합.과제5.model.dao;

import 종합.과제5.model.dto.WaitingDto;

// 실제 데이터가 존재하는 데이터 접근하는 기능 CRUD
public class WaitingDao { // class start

    // 싱글톤
    private WaitingDao(){}
    private static final WaitingDao dao = new WaitingDao();
    public static WaitingDao getInstance(){
        return dao;
    }

    // 데이터베이스
    private WaitingDto[] waitingDB = new WaitingDto[100];

    // 1) 등록 처리 메소드 : controller 로 부터 db(배열)에 저장할 객체를 받아서 저장
        // 매개변수 : WaitingDto , 반환값 : boolean
    public boolean addWaiting( WaitingDto waitingDto ){
        for( int i = 0; i<waitingDB.length ; i++){
            if( waitingDB[i] == null){
                waitingDB[i] = waitingDto;
                return true;
            } // if end
        } // for end
        return false;
    }
    // 2) 조회 처리 메소드 : controller로 부터 모든 db(배열)을 반환 한다.
        // 매개변수 : x         , 반환값 : WaitingDto[]
    public WaitingDto[] getWaitingList(){
        return waitingDB;
    } // func end

} // class end
