package day07;

public class Product {

    String Name;
    int stock = 10; // 멤버 변수 의 초기화
    //메소드
    boolean sell(int 구매수량){

       if (stock>=구매수량) {
       // 재고가 충분하면 재고를 줄이고 true 부족하면 false
           stock -= 구매수량;
           return true;
       }else{
           System.out.println("재고 부족");
           return false;
       } // if end
    } // func end
}// class end
