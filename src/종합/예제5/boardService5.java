package 종합.예제5;
//[JAVA] 종합예제5 : boardService5 (생성자)
//[ 목표 ] boardService4(종합예제4) 에서 객체 생성를 생성자로 변경 하시오.
//[ 이하 조건 ] : boardService4 동일

import java.util.Scanner;

public class boardService5 { // class start
    public static void main(String[] args) { // main start

                // * BoardController 클래스내 *메소드를 사용*하기 위한 객체 생성
                BoardController bs = new BoardController();

                for( ; ; ) {// (1) 무한루프 : 프로그램 계속적으로 실행하기 위해서
                    System.out.println("============= My Community =============");// (2) 출력
                    System.out.println("  1.게시물쓰기 | 2.게시물출력");
                    System.out.println("========================================");
                    System.out.print("선택 > ");
                    Scanner scan = new Scanner( System.in ); // (3) 입력
                    int choose = scan.nextInt();
                    if( choose == 1 ) { // (4) 입력 에 따른 화면 출력
                        System.out.print("내용 : ");
                        String content = scan.next();
                        System.out.print("작성자 : ");
                        String writer = scan.next();
                        boolean result = bs.doPost( content , writer );
                        if( result ){
                            System.out.println("[안내] 글쓰기 성공");
                        }else{
                            System.out.println("[경고] 글쓰기 실패");
                        }

                    }else if( choose == 2 ) {
                        System.out.println("============= 게시물 목록 =============");
                        Board[] boards = bs.doGet();
                        for ( int index = 0; index <= boards.length-1; index++) {
                            Board board = boards[index];
                            if( board != null) {
                                System.out.println("작성자 : " + board.writer);
                                System.out.println("내용 : " + board.content);
                                System.out.println("------------------------------------");
                            }
                        }
                    } // if end
                } // for end
    } // main end
} // class end
