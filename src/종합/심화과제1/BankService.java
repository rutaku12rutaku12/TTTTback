package 종합.심화과제1;

import java.util.Scanner;

public class BankService { // class start
    public static void main(String[] args) { // main start


        // 5) .
            // 1. accountNumber 과 pwd 멤버변수를 갖는 객체 필요하므로 Account 클래스 선언
            // 2. Account 클래스 객체를 100개 저장하는 배열을 controller 선언
            // 3. addAccount() 와 viewAccount() 메소드를 호출하기 위한 객체 생성
        BankController bs = new BankController();
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
                String accountNumber = scan.next();
                System.out.println("비밀번호 : ");
                String pwd = scan.next();

                System.out.println("[안내] 계좌 등록이 완료되었습니다.");

                // 6) * addAccount() 메소드를 호출해서 등록 처리 후 결과를 받는다.

                boolean result = // addAccount() 메소드가 실행후 결과를 result에 저장.
                    bs.addAccount( accountNumber , pwd ); // 입력받은 두 값을 인수로 전달
                if( result == true ) { // addAccount() 에서 true 반환이면
                    System.out.println("계좌등록 성공");
                }else { // addAccount() 에서 false 반환이면
                    System.out.println("계좌등록 실패");
                }
            }else if( choose == 2 ){ // 4) 번호 선택에 따른 출력
                System.out.println("--- 입금 ---");

                System.out.println("계좌번호 :");
                String accountNumber = scan.next();
                System.out.println("비밀번호 : ");
                String pwd = scan.next();
                System.out.println("입금액 : ");
                int plus  = scan.nextInt();

                System.out.println("[안내] 입금이 완료되었습니다.");

            }else if( choose == 3 ){ // 4) 번호 선택에 따른 출력
                System.out.println("--- 출금 ---");
                System.out.println("계좌번호 :");
                String accountNumber = scan.next();
                System.out.println("비밀번호 : ");
                String pwd = scan.next();
                System.out.println("출금액 : ");
                int minus  = scan.nextInt();

                System.out.println("[안내] 츨금이 완료되었습니다.");

            }else if( choose == 4 ){ // 4) 번호 선택에 따른 출력
                System.out.println("--- 잔고 확인 ---");
                Account[] accounts = bs.viewAccount();
                // addAccount() 반환된 accounts 배열 자료를 accounts에 대입한다.
                for ( int index = 0 ; index <= accounts.length-1; index++){
                    Account account = accounts[index];
                // 하나(객체) = 여러개(객체)배열[번호]
                    if( account != null){
                        System.out.println("계좌번호 :"+ account.accountNumber);
                        String accountNumber = scan.next();
                        System.out.println("비밀번호 : "+ account.pwd);
                        String pwd = scan.next();
                        System.out.println("[잔고] ");} // if end
                } // for end

            } // if end


        }// for 무한루프 end

    } // main end
} // class end

