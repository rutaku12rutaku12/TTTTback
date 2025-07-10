package 종합.과제4;

import java.util.Scanner;

public class WaitingService { // class start
    public static void main(String[] args) { // main start

        for( ; ; ){ // 1 무한루프 실행
            System.out.println("=========== 맛집 대기 시스템 ==========="); // 2 출력
            System.out.println("  1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.println("선택 > ");
            Scanner scan = new Scanner(System.in); // 3 입력
            int choose = scan.nextInt();
            if( choose == 1){ // 4 번호 입력에 따른 출력
                System.out.println("전화번호 : ");
                String phone = scan.next();
                System.out.println("인원수 : ");
                int count = scan.nextInt();
                boolean result = WaitingController.addWaiting( phone, count );
                if( result ) {System.out.println("[안내] 대기 등록이 완료되었습니다.");
                }else{System.out.println("[오류] 대기 등록이 실패했습니다. ");}
            }else if( choose == 2){
                System.out.println("============= 대기 현황 =============");
                Waiting[] waitings = WaitingController.getWaitingList();
                for( int i = 0 ; i<waitings.length ; i++){
                    Waiting waiting = waitings[i];
                    if( waiting != null ){
                        System.out.println("1. 연락처: "+waiting.getPhone()+ "\t-인원: "+waiting.getCount());
                        System.out.println("------------------------------------");
                    }
                }

            }// if end
        }// 무한루프 end

    } // main end
} // class end
