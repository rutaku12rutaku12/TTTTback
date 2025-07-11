package 종합.과제5.controller;

import 종합.과제5.model.dao.WaitingDao;
import 종합.과제5.model.dto.WaitingDto;

public class WaitingController { // class start
    // - Controller 싱글톤 만들기
    private WaitingController(){}
    private static final WaitingController control = new WaitingController();
    public static WaitingController getInstance(){
        return control;
    }

    // - DAO 싱글톤 객체 가져오기 : 멤버변수
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // 1. 등록 처리 메소드 :
    // view에서 전달받은 phone , count 를 객체로 구성하여 dao 에게 전달후 결과를 view에게 전달
    public boolean addWaiting( String phone , int count ) {
        WaitingDto waitingDto
                = new WaitingDto( phone , count ); // 1) 매개변수 객체화
        boolean result = waitingDao.addWaiting( waitingDto ); // 2) dao에게 객체를 전달후 결과받기
        return result; // 3) dao에게 받은 결과를 view에게 반환하기
    }

    // 2. 조회 처리 메소드 :
    public WaitingDto[] getWaitingList() {
        WaitingDto[] result = waitingDao.getWaitingList();
        return result;
    }

} // class end
