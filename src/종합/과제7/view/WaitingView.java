package 종합.과제7.view;

import 종합.과제7.controller.WaitingController;
import 종합.과제7.model.dto.WaitingDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class WaitingView {
    // (*) 싱글톤
    private WaitingView(){}
    private static final WaitingView instance = new WaitingView();
    public static WaitingView getInstance(){
        return instance;
    }
    // (*) 입력객체
    private Scanner scan = new Scanner(System.in);
    // (*) WaitingController 싱글톤 호출
    private WaitingController waitingController = WaitingController.getInstance();

    // (*) 메인 뷰
    public void index(){
        for( ; ; ){
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("1.대기 등록 | 2.대기 현황");
            System.out.println("=====================================");
            System.out.println("선택 > ");
            int choose = scan.nextInt();
            if( choose == 1 ){addWaiting();}
            else if( choose == 2 ){getWaitingList();}
        } // for end
    } // func end

    // (1) 등록 뷰
    public void addWaiting(){
        // 1. 입력받기
        System.out.println("전화번호 : ");  String phone = scan.next();
        System.out.println("인원수 : ");  String count = scan.next();
        boolean result = waitingController.addWaiting( phone,count ); // 2. controller 에게 입력값 전달 하고 결과 받기
        if( result ){
            System.out.println("[안내] 대기 등록이 완료되었습니다."); // 3. 결과에 따른 출력
        }else {
            System.out.println("[경고] 대기 등록이 실패했습니다.");
        }
    } // func end

    // (2) 대기현황 뷰
    public void getWaitingList(){
        // 1. controller 요청후 결과 받기
        ArrayList<WaitingDto> result =
                waitingController.getWaitingList();
        // 2. 결과를 반복하여 출력한다.
            System.out.println("============= 대기 현황 =============");
        for( WaitingDto dto : result ){
            System.out.printf("연락처: %s - 인원: %s명\n",dto.getPhone(),dto.getCount());
            System.out.println("------------------------------------");
        } // for end
    } // func end
} // class end
