package 종합.심화과제1;

import java.util.Scanner;

public class BankService { // class start
    public static void main(String[] args) { // main start



        for( ; ; ){ // 1) 무한루프 start
            System.out.println("============== KB Bank  =============="); // 2) 공통 부분 출력
            System.out.println("  1.계좌등록 | 2.입금 | 3.출금 | 4.잔고");
            System.out.println("======================================");
            System.out.println("선택 > ");

            Scanner scan = new Scanner(System.in); // 3) 콘솔에서 입력받기
            int choose = scan.nextInt();

            if( choose == 1){ // 4) 번호 선택에 따른 출력
                System.out.println("--- 계좌 등록 ---");
                System.out.println("계좌번호 :");
                System.out.println("비밀번호 : ");

                System.out.println("[안내] 계좌 등록이 완료되었습니다.");

            }else if( choose == 2 ){
                System.out.println("--- 입금 ---");
                System.out.println("계좌번호 :");
                System.out.println("비밀번호 : ");
                System.out.println("입금액 : ");

                System.out.println("[안내] 입금이 완료되었습니다.");

            }else if( choose == 3 ){
                System.out.println("--- 출금 ---");
                System.out.println("계좌번호 :");
                System.out.println("비밀번호 : ");
                System.out.println("출금액 : ");

                System.out.println("[안내] 츨금이 완료되었습니다.");

            }else if( choose == 4 ){
                System.out.println("--- 잔고 확인 ---");
                System.out.println("계좌번호 :");
                System.out.println("비밀번호 : ");
                System.out.println("[잔고] ");

            }


        }// for 무한루프 end

    } // main end
} // class end

