// 한줄 주석
/*
    여러줄 주석
*/


package day01; // 패키지(폴더) 현재 .JAVA 파일이 위치한 패키지명

public class Example1 { // class start
    // public : 프로젝트내 모든곳에서 (클래스) 호출 가능한 키워드 ㅡㄸㅅ
    // class : 클래스 선언(만들기) 뜻
    // 클래스명 : 첫글자를 대문자로 시작 * 아무거나 * 단 같은 폴더내 동일한 *중복명* 불가능
    // { } : 클래스 시작 , 클래스 끝
    // ************** 자바의 모든 코드는 클래스 안에서 작성 해야한다. ***************
    // * 자바는 컴파일(번역/처리) 단위를 무조건 *클래스*!!
    // * 클래스(설계도)

    // ----------------------------------------
    // 비교 1
    int a = 10; // 변수 a 선언
    //System.out.print( a ); // 출력함수 실행

    // 비교 2  , main 자동완성 엔터
        // JS를 실행하는 방법 : HTML파일을 브라우저 실행하면 HTML안에 포함된 JS 실행
        // 자바를 실행하는 방법 : main함수( *스레드 포함 ) 라는 함수가 자동 실행 되면서 코드를 순차적으로 읽는다.
        // 인텔리제이 에서 main 함수 실행 방법 : (1) main함수 왼쪽에 (|>) 화살표 클릭 (2) ctrl+shift+f10
    public static void main(String[] args) { // 함수 정의
        int b = 28; // 변수 b 선언
        System.out.print( b ); // 출력함수 실행
    } // main end





} // class end


