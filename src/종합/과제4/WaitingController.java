package 종합.과제4;

public class WaitingController {  // class start
    // 1 멤버변수
    private static final Waiting[] waitings = new Waiting[100];
    // 2 생성자
    // 3 메소드
        // 등록 메소드
    public static boolean addWaiting(String phone, int count){
        Waiting waiting = new Waiting( phone , count ); // 매개변수로 객체 생성
        // 배열내 빈공간을 찾아 생성한 객체 대입
        for( int i=0; i<waitings.length; i++){
            if( waitings[i] == null ){
                waitings[i] = waiting;
                return  true; // 저장성공 뜻을 true로 부여하여 반환
            } // if end
        } // for end
        return false; // 저장실패 뜻을 false로 부여하여 반환
    } // func end
        // 조회 메소드
    public  static Waiting[] getWaitingList(){
        return waitings;
    }
} // class end
