package 종합.과제5.view;

import 종합.과제5.controller.WaitingController;
import 종합.과제5.model.dto.WaitingDto;

import java.util.Scanner;


// 게시물 관련 입출력 클래스
public class WaitingView { // class start
    // 싱글톤 만들기 1,2,3단계
    private WaitingView(){} // 1단계
    private static final WaitingView view = new WaitingView(); // 2단계
    public static WaitingView getInstance(){ // 3단계
        return view;
    }

    // 여러 메소드에서 사용할 입력 객체를 멤버변수로 선언
    private Scanner scan = new Scanner(System.in);

    // - Controller 객체 가져오기 : 멤버변수
    private WaitingController waitingController
            = WaitingController.getInstance();
    // 1) 메인view : 최초로 보이는 화면
    public void index(){
        for( ; ; ) {
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("  1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.println("선택 > ");
            int choose = scan.nextInt();
            if( choose == 1 ){ addWaiting(); }
            else if( choose ==2){getWaitingList(); }
        }
    } // func end

    // (2) 등록view
    public void addWaiting(){
        System.out.println("전화번호 : ");
        String phone = scan.next();
        System.out.println("인원수 : ");
        int count = scan.nextInt();
        boolean result = waitingController.addWaiting( phone,count );
        // - 입력받은 값들을 controller 전달후 반환값 저장
        if( result ){System.out.println("[안내] 대기 등록이 완료되었습니다.");}
        else{System.out.println("[경고] 대기 등록이 실패했습니다.");}
    } // func end

    // (3) 조회view
    public void getWaitingList(){
        System.out.println("============= 대기 현황 =============");
        WaitingDto[] result = waitingController.getWaitingList(); // controller 에게 조회를 요청하고 결과를 저장한다.
        for( int i = 0 ; i< result.length ; i++){
            WaitingDto waitingDto = result[i];
            if( waitingDto != null ){
                System.out.println("전화번호: "+ waitingDto.getPhone() );
                System.out.println("인원수 : "+ waitingDto.getCount() );
                System.out.println("------------------------------------");
            } // if end
        } // for end
    } // func end

} // class end

