package 종합.예제3;

import java.util.Scanner;

public class BoardService3 { // class start
//    [JAVA] 종합예제3 : boardService3 (객체 활용)
//[ 목표 ] 종합예제2 에서 객체 문법 추가하여 , 최대 100개의 게시물을 저장하고 조회할 수 있는 간단한 콘솔 게시판 프로그램을 구현합니다.
//[ 요구사항 ]
//            1. 게시물 저장 공간 만들기
//        · 최대 100개의 게시물을 저장할 수 있어야 합니다.
//            · 각 게시물은 '내용'과 '작성자' 속성 를 가지는 Board 클래스 선언하시오..
//            · 총 1개의 Board[] 배열변수를 선언하여 저장 공간을 만드세요. (예: Board[] boards = new Board[100] )
//            · 모든 변수는 null로 초기화하여, 해당 공간이 비어있음을 나타내도록 합니다.
//            2. 메인 프로그램 흐름 구현하기
//        · 프로그램은 사용자가 강제 종료하기 전까지 계속 실행되어야 합니다. for(;;) 무한루프를 사용하세요.
//            · 무한루프 안에서 사용자에게 메뉴를 보여주고, Scanner를 통해 원하는 기능의 번호를 입력받으세요.
//            · 기능 1: 게시물 쓰기 (입력값: 1)
//            - 사용자가 1을 입력하면, "내용 : "과 "작성자 : "를 순서대로 물어보고 입력받습니다.
//            - Board 객체로 생성하여 입력받은 '내용' 과 '작성자'를 각 멤버변수에 대입 합니다.
//            - 가장 먼저 발견된 빈 공간에 입력받은 내용과 작성자를 저장하고 "[안내] 글쓰기 성공" 메시지를 출력합니다.
//            - 게시물 공간이 모두 차 있다면, "[경고] 게시물을 등록할 공간이 부족합니다." 라는 메시지를 출력합니다.
//        · 기능 2: 게시물 출력 (입력값: 2)
//            - 사용자가 2를 입력하면, 저장된 모든 게시물을 아래 형식으로 출력합니다.
//            - 저장 공간이 비어있지 않은(null이 아닌) 경우에만 출력합니다.
//            [ 실행 예시 ]  <종합예제2 과 동일 참고>
//            ============= My Community =============
//            1.게시물쓰기 | 2.게시물출력
//========================================
//    선택 > 1
//    내용 : 안녕하세요
//    작성자 : 유재석
//[안내] 글쓰기 성공
//
//============= My Community =============
//            1.게시물쓰기 | 2.게시물출력
//========================================
//    선택 > 1
//    내용 : 반갑습니다
//    작성자 : 강호동
//[안내] 글쓰기 성공
//
//============= My Community =============
//            1.게시물쓰기 | 2.게시물출력
//========================================
//    선택 > 2
//            ============= 게시물 목록 =============
//    작성자 : 유재석
//    내용 : 안녕하세요
//------------------------------------
//    작성자 : 강호동
//    내용 : 반갑습니다
//------------------------------------
//
//        ============= My Community =============
//            1.게시물쓰기 | 2.게시물출력
//========================================
//    선택 > 1
//    내용 : 테스트
//    작성자 : 이수근
//[경고] 게시물을 등록할 공간이 부족합니다.
//
public static void main(String[] args) { // main start

    // (5)
    // boardService1_변수활용 : 게시물 3개 --> 변수6개 , 게시물 100개 --> 변수 200개 *유지보수 힘듬
    // boardService2_배열활용 : 게시물 100개 -> 변수2개
    // boardService3_객체할용 : 게시물 100개 -> 변수2걔(객체화) -> 변수1개

        // 1. 다양한 속성을 하나의 클래스로 설계하자. content와 writer 를 하나의 객체
        // 2. 설계한 클래스/타입 으로 배열 선언

        Board[] boards = new Board[100]; // boards 변수에 Board객체 100개를 저장하는 배열 자료1개 저장
    // 변수1개 , 배열1개 , 객체100저장공간
                                                                            // 1) 출력
        for( ; ; ){
            System.out.println("============= My Community =============");
            System.out.println("1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.println("선택 > ");
                                                                             // 2) 입력
            Scanner scan = new Scanner(System.in);                           // 3) 입력객체 생성
                int choose = scan.nextInt();
                // 선택 판단
                if( choose == 1 ) {                                          // 4) '1번'선택시 입력에 따른 출력 구현.

                    System.out.println("내용 : "); String content = scan.next();            // (6) 입력받은 값 저장
                    System.out.println("작성자 : "); String writer = scan.next();
                    Board board = new Board();      // (6) 객체생성하여 입력받은 값 대입
                    board.content = content;
                    board.writer = writer;
                    boolean check = false; // true : 저장성공 , false : 저장실패
                    for( int index = 9; index <= boards.length -1 ; index++){  // (6) 배열내 빈공간을 찾아서 빈공간에 객체 대입
                        if( boards[index] == null ) { // index번째 요소가 비어(null) 있으면
                            boards[index] = board; // 해당 index번째의 생성한 객체를 대입한다.
                            check = true; // 상태변경
                            break; // 목표 이뤘으니 반복문 종료
                        }// if end
                    } // for end
                    if( check ){ System.out.println("[안내] 글쓰기 성공");} // (6) 안내
                    else{ System.out.println("[경고] 게시물을 등록할 공간이 부족합니다.");}


                }else if( choose == 2) {                                     // 4) '2번'선택시 입력에 따른 출력 구현.
                    System.out.println("============= 게시물 목록 =============");
                    // (7) 배열내 요소(Board객체) 가 비어있지 않으면 board객체 출력하시오.
                    for( int index =0 ; index <= boards.length -1 ; index ++){
                        if( boards[index] != null ) { // index번째 요소 (객체)가 비어 있지 않으면
                            System.out.println("작성자 : " +boards[index].writer); // 변수명[인덱스].멤버변수명
                            System.out.println("내용 : " +boards[index].content);
                            System.out.println("------------------------------------");
                        } // if end
                    } // for end

                } // if end

        } // for end



    } // main end

} // class end
