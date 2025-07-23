package 종합.예제10;

import 종합.예제10.controller.Boardcontroller;
import 종합.예제10.model.dto.BoardDto;
import 종합.예제10.view.BoardView;

import java.util.ArrayList;

public class AppStart {
    public static void main(String[] args) {

        // 1. 20250723 등록 테스트-> 테스트 성공 후 주석처리
        // boolean result = Boardcontroller.getInstance().boardWrite("테스트내용","강사");
        // System.out.println(result);

        // 2. 20250723 전체조회 테스트
        // ArrayList<BoardDto> result2 = Boardcontroller.getInstance().boardPrint();
        // System.out.println(result2);


        // * 메인화면 호출
        BoardView.getInstance().index();
    }
}
