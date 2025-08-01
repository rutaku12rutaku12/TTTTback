package day07;

public class Example1 { // class start
    public static void main(String[] args) { // main start

        /*
        [메소드] , 멤버함수 또는 메소드
            1. 정의 : 하나의 기능을 수행하는 일련의 코드
            2. 메소드 선언/만들기
                반환타입 메소드명( 타입 매개변수1 , 타입 매개변수2 ) {
                    실행코드;
                    return 반환값|생략가능
                }
            3. 용어
                1). 메소드명 : (1) 카멜표기법 권장 , mycarrun -> myCarRun
                2). 매개변수 : 메소드 실행시 메소드 안으로 들어오는 값을 저장하는 변수
                    (1). 매개변수 없을수도 있다.
                    (2). *** 인수값의 타입과 매개변수의 타입이 일치해야한다. ***
                    (3). 지역변수
                3). 반환타입 : 메소드 실행후 결과를 되돌려(return) 주는 값의 타입
                4). 반환값 : 메소드 실행후 결과를 되돌려(return) 주는 값
                    (1). *** 반환값의 타입과 반환타입의 타입이 일치해야한다. ***
                    (2). 반환값은 항상 자료 1개 만 가능 하다.
                    (3). 반환값이 없을때는 void 반환타입 키워드 사용한다.
                5). 인수값 : 메소드 호출시 메소드에게 전달하는 값 , 인수값 ---대입(중매)--> 매개변수
            4. 메소드를 호출하는 방법 :
                [방법1] 호출하고자 하는 메소드가 다른 클래스 일때
                    1) 클래스 변수명 = new 클래스명();
                    2) 변수명.메소드명();

        */

        // [1] 클래스 에서 메소드 선언
        // [2] 다른 클래스내 메소드 호출하기.
            // 1) 호출하고자 하는 메소드를 갖는 클래스로 객체생성
        Calculator cal1 = new Calculator();
            // 2) 호출하고자 하는 메소드를 갖는 객체 이용한 메소드 호출
        cal1.getPi();   // 객체.메소드명();

        // [3] 매개변수 X , 반환값 O : 반환값이 있을때 주로 변수에 대입한다.
        double result = cal1.getPi();
        System.out.println( result );

        // [4] 매개변수 X , 반환값 X
        cal1.powerOn();
            // - 여러 객체들관의 멤버변수 주의할점 -
        Calculator cal2 = new Calculator();
            // - new 연산자는 항상 새로운 객체를 만든다.
            // 즉] 객체 마다 멤버변수는 다르다.
        System.out.println( cal1.isPowerOn );
        System.out.println( cal2.isPowerOn );
        // [5] 매개변수 O , 반환값 X
        cal1.printSum(3 ,5); // 2개의 정수 인수값 x:3 , y:5
        // 오류발생 인수값과 매개변수 타입이 불일치
        // cal1.printSum( 3.14 , 5.1);
        cal2.printSum(10 ,2 );

        // [6] 매개변수 O , 반환값 O
        int result2 = cal1.add( 10 ,3 );
        // int : .add 함수의 반환값 타입이 int 라서.
        System.out.println(result2);

        int a = 1;
        // int result3 = cal1.add("안녕" , a );
        // 오류발생 : 인수값 과 매개변수의 타입 일치해야한다.




    } // main end
}   // class end
