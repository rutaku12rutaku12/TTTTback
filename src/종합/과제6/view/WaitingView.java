package 종합.과제6.view;

import 종합.과제6.controller.WaitingController;
import 종합.과제6.model.dto.WaitingDto;

import java.util.ArrayList;
import java.util.Scanner;

public class WaitingView {
    // 1) 싱글톤
    private WaitingView(){}
    private static final WaitingView instance = new WaitingView();
    public static WaitingView getInstance(){
        return instance;
    }
    // 2) 싱글톤 가져오기
    private WaitingController waitingcontroller = WaitingController.getInstance();


    // * 스캐너
    Scanner scan = new Scanner(System.in);

    // 최초 화면
    public void index(){
        for( ; ; ){
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("  1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.println("선택 > ");
            int choose = scan.nextInt();
            if( choose == 1 ){addWaiting();}
            else if( choose == 2){ getWaitingList();}
        }
    }
    // 3) 등록 입출력 구현
    public void addWaiting(){
        // 1. 안내와 입력받기
        System.out.println("전화번호 : ");  String phone = scan.next();
        System.out.println("인원수 : ");    int count = scan.nextInt();
        // 2. controller에게 입력받은 값 인수로 전달후 결과(리턴)받기
        boolean result = waitingcontroller.addWaiting(phone,count);
        // 3. 결과/리턴 따른 출력문
        if( result == true ) {
            System.out.println("[안내] 글쓰기 성공");
        }else{
            System.out.println("[경고] 글쓰기 실패");
        }
    } // func end
    // 4) 전체조회 입출력 구현
    public void getWaitingList(){
        System.out.println("============= 대기 현황 =============");
        // 1. controller 에게 요청후 결과(리턴)받기
        ArrayList<WaitingDto> result = waitingcontroller.getWaitingList();
        // 2. 받은 결과물들을 반복문 출력
        for( int i=0; i<result.size();i++) {
            WaitingDto waiting = result.get(i);
            System.out.printf("%d. 연락처: %s\t- 인원 : %d명 \n",i+1,waiting.getPhone(),waiting.getCount() );
            System.out.println("------------------------------------");
        } // for end
    } // func end
} // class end
