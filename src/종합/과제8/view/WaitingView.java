package 종합.과제8.view;

import 종합.과제8.controller.WaitingController;
import 종합.과제8.model.dao.WaitingDao;
import 종합.과제8.model.dto.WaitingDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WaitingView {
    // *) 싱글톤
    private WaitingView(){}
    private static final WaitingView instance = new WaitingView();
    public static WaitingView getInstance(){
        return instance;
    }
    // (*) 모든 메소드가 사용 가능하도록 메소드 밖에 입력객체 생성
    private Scanner scan = new Scanner(System.in);
    // (*) 싱글톤 가져오기
    private WaitingController waitingController = WaitingController.getInstance();

    // (*) 메인화면
    public void index(){
        for( ; ; ){
            try {
                System.out.println("====== 대기 등록 ======");
                System.out.println("1.등록 2.등록조회 3.삭제 4.수정 >선택");
                int choose = scan.nextInt();
                if (choose == 1) {waitingAdd();}
                else if(choose == 2){waitingPrint();}
                else if(choose == 3){waitingDelete();}
                else if(choose == 4){waitingUpdate();}
                else {System.out.println("[경고] 존재하지 않는 번호입니다.");}
            }catch (InputMismatchException e){
                System.out.println("[경고] 1~4 사이의 숫자를 입력해주세요.");
                scan = new Scanner(System.in); // 입력 초기화
            }catch (Exception e){System.out.println("[오류] 관리자에게 문의하세요.");}

        } // for end
    }// func end

    // (1) 등록 화면 구성
    public void waitingAdd(){
        // 1. 입력받기
        System.out.println("연락처 : "); String wphone = scan.next();
        System.out.println("인원수 : "); int wcount = scan.nextInt();
        // 2. controller 전달하기 // 3. 전달 후 리턴값 저장하기
        boolean result = waitingController.waitingAdd(wphone,wcount);
        // 4. 리턴된 값 에 따른 출력하기
        if( result ){
            System.out.println("[안내] 대기 등록 성공");
        }else {
            System.out.println("[경고] 대기 등록 실패");
        }
    } // func end

    // (2) 전체 조회 화면 구현
    public void waitingPrint(){
        // 1. controller 에게 요청후 결과 받기
        ArrayList<WaitingDto> result = waitingController.waitingPrint();
        // 2. 결과에 따른 화면 구현
        System.out.println("----------------------------------");
        System.out.println("no \t 연락처 \t \t 인원수");
        System.out.println("----------------------------------");
        for(WaitingDto dto : result){
            System.out.printf("%d \t %s \t \t %d \n",
                    dto.getWno() , dto.getWphone(), dto.getWcount() );
        } // for end
    } // func end

    // (3) 삭제 화면 구현
    public void waitingDelete(){
        // 1.입력받기
        System.out.println("삭제할 대기번호 : "); int wno = scan.nextInt();
        // 2. controller 전달하기 // 3. 전달후 리턴값 저장
        boolean result = waitingController.waitingDelete(wno);
        // 4. 리턴된 값에 따른 출력하기
        if( result ) {System.out.println("[안내] 삭제 성공");}
        else {System.out.println("[경고] 없는 번호 이거나 실패");}
    } // func end

    // (4) 수정화면 구현
    public void waitingUpdate(){
        // 1. 입력받기
        System.out.println("수정할 대기번호 : "); int wno = scan.nextInt();
        System.out.println("수정할 연락처 : "); String wphone = scan.next();
        System.out.println("수정할 인원수 : "); int wcount = scan.nextInt();
        // 2. controller 전달 // 3. 전달후 리턴값 저장
        boolean result = waitingController.waitingUpdate( wno , wphone , wcount );
        // 4. 리턴된 값 에 따른 출력
        if( result ){System.out.println("[안내] 수정 성공");
        }else {System.out.println("[경고] 없는 번호 이거나 수정 실패");}

    } // func end

} // class end





















