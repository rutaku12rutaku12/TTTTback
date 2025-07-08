package 종합.과제3;

public class WaitingController { // class start
    // 1. 멤버변수
    Waiting[] waitings = new Waiting[100];
    // 2. 메소드
    // 2-1 등록 메소드
    boolean addWaiting(String phone, int count){
        // -  Waiting 객체를 생성하고,
        Waiting waiting = new Waiting(); // - 객체 생성
        waiting.phone = phone;  // 매개변수로 받은 값들을 객체의 멤버 변수에 저장
        waiting.count = count;
        // waiting 배열의 빈 공간(null)을 찾아 생성된 객체를 저장
        for (int index=0; index<=waitings.length - 1 ; index++){
            if( waitings[index] == null) { // 만약에 index번째 요소의 값이 null 이면
                waitings[index] = waiting; // index번째에 생성한 객체를 대입
                return true; // 저장 성공시 true
            }
        } // for end
        return false; // 실패(공간 없음) 시 false를 반환(return)
    }  // func end
    // boolean : 저장 성공시 true, 실패(공간없음) 시 false를 반환(return)합니다.
    // ( String content , String writer ) : 매개변수로 content와 writer를 받습니다.

    // 2-2 조회 메소드
    Waiting[] getWaitingList(){
        return waitings;
    }

    // waitings 배열 전체를 반환(return)
    // waitings 타입은 Wating[]

} // class end
