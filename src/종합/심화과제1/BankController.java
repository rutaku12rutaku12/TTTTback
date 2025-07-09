package 종합.심화과제1;

public class BankController { // class start

    // 1. 멤버변수
    Account[] accounts = new Account[100];
    // 2. 메소드
    // 2-1 등록 메소드
    boolean addAccount(String accountNumber, String pwd){
        // = Account 객체를 생성하고
        Account account = new Account(); // 객체 생성
        account.accountNumber = accountNumber; // 매개변수로 받은 값들을 객체의 멤버 변수에 저장
        account.pwd = pwd;
        // accounts 배열의 빈 공간(null)을 찾아 생성된 객체를 저장
        for( int index=0; index<= accounts.length - 1 ; index++) {
            if( accounts[index] == null) { // 만약에 index번째 요소의 값이 null 이면
                accounts[index] = account; // index번째에 생성한 객체를 대입
                return true; // 저장 성공 시 true;
            }

        } // for end
        return false; // 실패(공간 없음) 시 false를 반환(return)
    } // func end
    // boolean : 저장 성공시 ture , 실패시 false 반환
    // ( String accountNumber , String pwd ) : 매개변수로 accountNumber와 pwd 를 받습니다.

    // 2-2 조회 메소드
    Account[] viewAccount(){
        return accounts;
    }
    // accounts 배열 전체를 반환(return)
    // accounts 타입은 Account[]

    // 2-3 입금 메소드
    //boolean pluscount(){}

    // 2-4 출금 메소드

} // class end
