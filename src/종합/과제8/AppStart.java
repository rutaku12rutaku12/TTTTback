package 종합.과제8;

import 종합.과제8.controller.WaitingController;
import 종합.과제8.model.dto.WaitingDto;
import 종합.과제8.view.WaitingView;

import java.util.ArrayList;

public class AppStart {
    public static void main(String[] args) {

        // 등록 테스트 성공 -> 주석처리
        // boolean result = WaitingController.getInstance().waitingAdd("010-9919-0905",4);
        // System.out.println(result);

        // 전체조회 테스트 성공 -> 주석처리
        // ArrayList<WaitingDto> result2 = WaitingController.getInstance().waitingPrint();
        // System.out.println(result2);

        // 삭제 테스트 성공 -> 주석처리
        // boolean result3 = WaitingController.getInstance().waitingDelete(21);
        // System.out.println(result3);

        // 수정 테스트 성공 -> 주석처리
        // boolean result4 = WaitingController.getInstance().waitingUpdate(19,"010-1919-9987",1);
        // System.out.println(result4);

        // * 메인화면 호출
        WaitingView.getInstance().index();

    }
}
