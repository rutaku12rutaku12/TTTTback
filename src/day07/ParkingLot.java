package day07;

public class ParkingLot { // class start

    int calculateFee( int x ){ // func start
    int money = 0;
        if(x<=30){
            money = 3000;
            return money;
        }else if(money >=20000){
            money = 20000;
            return money;
        }else{ money= ((x-30)/10*500+1000) ;
            return money; } // if end

    } // func end
} // class end
