package day06;

public class Example2 { // class start
    public static void main(String[] args) { // main start
        /*
            [ 클래스 와 객체 ]
                1) 객체 : '주체'가 아닌 의사나 행위를 미치는 대상
                2) 객체 종류 : 모든것들 , 속성과 기능을 정의 한다면
                    사람(물리), 주문(논리) , 안경(물리) , 공기(물리) , 강의(논리) 등등
                3) 객체지향 프로그래밍 : 개발자(주체)가 컴퓨터 안에서 (객체)대상 만들기
                4) 클래스 : 객체를 만들기 위한 설계도 , 속성 과 기능 코드로 표현
                    - 속성 : 대상의 본질적인 특징/성질/특성    -> 멤버변수
                    - 기능 : 대상의 작동/행위/이벤트          -> 멤버함수 , 메소드
                * 자바의 모든 코드는 컴파일은 클래스 단위로 컴파일 한다. *
                5) 예시 생활속 예시
                    (1) 학생 객체 만들기
                        1. 클래스 정의한다.        즉] 속성 과 기능 만들기 --> 특징 , 이벤트 만들기
                            -> 학생에게 속성 부여 : 학번 , 이름 , 전화번호
                            -> 학생에게 이벤트 부여 : 공부하기() , 밥먹기() , 잠자기()
                        2. 객체 정의한다.
                            new 클래스명();  // 예시: new 학생();
                        3. 객체네 멤버변수 , 메소드 접근
                            학생.학번
                    (2) 붕어빵 객체 만들기
                        1. 클래스(붕어빵틀) 정의한다.
                            -> 속성 : 내용물 , 가격
                            -> 이벤트 : 굽기() , 꺼내기() , 판매()
                        2. 객체 정의한다.
                            new 붕어빵틀();
                        3. 객체내 멤버변수
                            붕어빵.내용물


                6) 사용법
                        방법1) class 클래스명{ 타입 멤버변수명; }          : 클래스 만들기
                        방법2)
                    < 객체 만들기 >
                        방법1) new 클래스명();
                        방법2) 클래스명 변수명 = new 클래스명();
                    < 객체 내 멤버변수 호출  : .(접근연산자)>
                        변수명.멤버변수
                    < 객체 내 멤버변수 값 수정 >
                        변수명.멤버변수 = 새로운 값
                    < 객체 내 멤버변수 추가 /삭제 불가능 >
                        - 실행 도중에 클래스 정보를 수정할 수 없다. 단점] 유연성 떨어짐 -> MAP/JSON
        */
        // [1] 학생 클래스 만들기, 학생 객체를 만들기 위한 학생 속성과 기능을 정의하는곳
            // 1. 클래스 밖에서 선언          : class 클래스명{ }

        // [2] 학생 클래스 이용한 객체 만들기 : 자바는 객체를 만들기 위해서 *무조건*클래스가 필요하다.
            // 2. 객체 만들기                : new 클래스명 ( );
        new Student(); // 객체 생성
        // [3] 주로 생성된 객체는 변수에 대입/저장 한다. 타입 변수명 = 값 : , 타입 변수명 = 객채 ;
            // * 객체를 저장하는 변수의 타입은 객체의 클래스/타입 로 선언한다.
        Student s1 = new Student();
        // [4] 생서된 객체 정보 호출
        System.out.println( s1 ); // day06.Student@119d7047 : 객체의 주소(컴퓨터내 메모리 위치)값이 반환된다.
        // [5] 객체내 멤버변수 호출
        System.out.println( s1.studentName); // null : 객체내 멤버변수에 초기값이 없으면 기본값이 대입된다.
        // [6] 객체내 멤버변수 값 수정
        s1.studentName = "유재석";
        // [7] 객체내 멤버변수 삭제/추가 불가능 : 실행 도중에 클래스 정보를 수정할 수 없다.

        // [8] 붕어빵 객체 만들기
            // 1) 붕어빵 객체 만들기 위한 붕어빵(틀) 클래스/설계도 만들기
            // - 붕어빵 장사를 하기전에 붕어빵 주인은 붕어빵틀(기계) 구매한다.

            // 2) 붕어빵 객체 만들기 ,
                // - 손님이 팥2개 , 슈크릠1개 주세요.
//        붕어빵들 빵1 = new 붕어빵들();
//        빵1.내용물 = "팥";
//        빵1.가격 = 1000;   // --- 팥 붕어빵 객체 생성
//
//        붕어빵틀 빵2 = new 붕어빵들();
//        빵2.내용물 = "팥";
//        빵2.가격 = 1000; // --- 팥 붕어빵 객체 생성
//        // * 객체내 동일한 데이터를 갖더라도 서로 다른 객체이다.
//        // * new 연산자는 항상 새로운 객체를 만들어내는 객체 생성 키워드
//
//        붕어빵틀 빵3 = new 붕어빵틀();
//        빵3.내용물 = "슈크림";
//        빵3.가격 = 1500;   // - 슈크림 붕어빵 객체 생성
//
//        // 3) 객체의 배열의 관계 : 배열은 동일한 타입/클래스 데이터/객체를 여러개 저장
//            // - 주문한 붕어빵 3개를 비닐봉지에 넣어주세요.
//        붕어빵[] 빵봉지 = { 빵1 , 빵2 , 빵3 };
//            // * 서로 다른 속성/타입 들을 데이터들은 묶음 --> 객체 화 , 내용물/가격 --> 객체
//            // * 서로 같은 속성/타입 들은 데이터들은 묶음 --> 배열 화


    }   // main end
}   // Example1 class end

class Student { // 클래스란? 객체를 만드는 코드가 아닌 객체를 만들기 위해 객체내 필요한 속성 과 기능을 설계/정의
    int studentID; // '학번' 속성 정의
    String studentName; // '이름' 속성 정의
}   // Student 클래스 end