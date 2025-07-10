package 종합.예제6;

    import java.util.Scanner;

public class BoardService6 { // class start
    public static void main(String[] args) { // main start

        // 예제4/5번 과 다르게 static 으로 구성된 메소드는 객체가 필요없다.

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
                boolean result = BoardController.doPost( content , writer ); // 클래스명.static메소드명( );
                if (result ){System.out.println("[안내] 글쓰기 성공");}
                else {System.out.println("[경고] 글쓰기 실패");}
            }else if( choose == 2 ) {
                System.out.println("============= 게시물 목록 =============");
                Board[] boards = BoardController.doGet();
                for (int i = 0; i < boards.length; i++) {
                    Board board = boards[i];
                    if (board != null) { // boards.content : private 이라서 불가능
                        System.out.println("작성자 : " + board.getWriter());
                        System.out.println("내용 : " + board.getContent());
                        System.out.println("------------------------------------");
                    } // if end
                } // for end
            } // if end
        } // for end
    } // main end
} // class end
