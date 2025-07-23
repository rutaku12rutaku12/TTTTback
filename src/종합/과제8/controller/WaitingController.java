package 종합.과제8.controller;

import 종합.과제8.model.dao.WaitingDao;
import 종합.과제8.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingController {
    // *) 싱글톤
    private WaitingController(){}
    private static final WaitingController instance = new WaitingController();
    public static WaitingController getInstance(){
        return instance;
    }
    // (*) 싱글톤 객체 가져오기
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // (1) 등록 기능 구현
    public boolean waitingAdd( String wphone , int wcount ){
        // 1. 객체 하나로 만들기
        WaitingDto waitingDto = new WaitingDto( 0 , wphone ,wcount );
        // 2. 객체화 된 dto 를 dao 에게 전달 후 결과 받기
        boolean result = waitingDao.waitingAdd( waitingDto );
        // 3. 결과를 view에게 리턴
        return  result;
    } // func end

    // (2) 전체조회 기능 구현
    public ArrayList<WaitingDto> waitingPrint(){
        // dao 에게 요청 후 결과 받기
        ArrayList<WaitingDto> result = waitingDao.waitingPrint();
        // 결과를 view에게 반환 하기
        return result;
    } // func end

    // (3) 삭제 기능 구현
    public boolean waitingDelete( int wno ){
        // 1.유효성검사  2.객체화 pass
        // 3. dao에게 삭제할번호 전달후 결과를 받는다.
        boolean result = waitingDao.waitingDelete(wno);
        // 4. 결과를 view에게 리턴한다.
        return result;
    }// func end

    // (4) 수정 기능 구현
    public boolean waitingUpdate( int wno , String wphone , int wcount){
        // 1.유효성검사 pass
        // 2.객체화
        WaitingDto waitingDto = new WaitingDto( wno , wphone , wcount );
        // 3. dao에게 삭제할번호 전달후 결과를 받는다.
        boolean result = waitingDao.waitingUpdate( waitingDto );
        // 4. 결과를 view에게 리턴한다.
        return result;

    }// func end
} // class end
























