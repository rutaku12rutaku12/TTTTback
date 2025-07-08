package day07;

// - 클래스 목적
// (1) 실행 클래스 : main함수 갖는 클래스
// (2) 객체 설계 클래스 : 객체 만들기 위한 객체정의클래스

public class Calculator {
    // 클래스 멤버(객체내포함)
    // 1. 멤버변수 : 객체마다 할당
    boolean isPowerOn = false; // 전원상태


    // 3. 생성자
    // 2. 메소드 : 하나의 메소드는 여러 객체들이 공유
    // (1) 매개변수x 반환값o
    double getPi(){
    // double : return(반환)할 값의 타입이 실수
    // getPi : 메소드명 , 카멜표기법 권장 , 아무거나
    // ( )   : 매개변수 , 없다.
        return 3.14159;
    // return 값 : 메소드를 호출 했던곳을 반환하는 값;

    } // func end

    // (2) 매개변수X 반환값X(void)
    void powerOn(){
    // void : return(반환)할 값이 없다는 키워드
    // { } : 메소드 실행 될때 처리할 코드들
        System.out.println("계산기 전원을 켭니다.");
        isPowerOn = true;
    // ispowerOn : *해당 메소드를 호출한 객체의************멤버변수***********
    } // func end

    // (3) 매개변수O , 반환값 X
    void printSum( int x , int y ) {
    // ( int x , int y ) : 메소드 호출시 인수값을 정수 2개를 저장하는 변수
        if( isPowerOn ){ // 만약에 전원이 켜져 있으면
            int sum = x + y ;
            System.out.println( sum );
            return; // 생략가능
        }else{
            System.out.println("전원이 꺼져 있습니다.");
            return;
        }
    } // func end

    // (4) 매개변수 O , 반환값 O
    int add( int x, int y){
        if( isPowerOn ){
            int result = x + y;
            return result;
    // return 값 : 메소드를 호출했던곳으로 반환되는 값
        }else{
            System.out.println("전원이 꺼져있다.");
            return 0;
        }
    }

} // class end

// 웹/앱 개발 : 패턴 싸움
