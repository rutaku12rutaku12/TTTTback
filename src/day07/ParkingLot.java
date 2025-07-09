package day07;

public class ParkingLot { // class start

    int calculateFee( int time ){ // func start
        // 메소드/API 설계
        // 1. 함수명 : calculateFee
        // 2. 매개변수 : 주차 시간(분) , int time
        // 3. 반환값 : 최종 주차 요금 ,int money
    int money = 0;
        if(time<=30){
            money = 3000;
        }else if(money >=20000){
            money = 20000;
        }else{ money= ((time-30)/10*500+1000) ;
             } // if end
        return money;
    } // func end
} // class end
