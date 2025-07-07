package day06;

import java.util.Scanner;

// ========================= 1) .java 파일내 여러개 클래스 선언 ======================== //
class Book {
    // 멤버변수
    String title;
    String author;
    int price;

} // class end

public class 실습7 { // class start
    public static void main(String[] args) {    // main start

        // * 자바에서 객체 생성하기 위해서는 *클래스* 필요하다.
        // 1) .java (실습7) 파일내 여러개 클래스 선언
        Book b1 = new Book(); // (2) 객체 생성 한다. , new 클래스명();
        Book b2 = new Book(); // 주로 생성된 객체는 변수에 저장한다.
        b1.title = "이것이 자바다"; // (3) "이것이 자바다", "신용권", 30000 "자바의 정석", "남궁성", 28000
        b1.author = "신용권";
        b1.price = 30000;
        b2.title = "자바의 정석"; // (3) "자바의 정석", "남궁성", 28000
        b2.author = "남궁성";
        b2.price = 28000;
        System.out.println( b1.title + "\t" + b1.author + "\t"+ b1.price ); // (4) 두 객체의 모든 정보를 각각 출력
        System.out.println( b2.title + "\t" + b2.author + "\t"+ b2.price );

        // 2) 새로운 .java 파일 생성하여 클래스 선언 (권장)
        Pet p1 = new Pet(); // (2) 객체 생성한다.
        Pet p2 = new Pet(); // 클래스 명 변수명 = new 클래스명();
        p1.name = "초코"; p1.species = "푸들"; p1.age =3; // (3) 첫 번째 객체에는 "초코", "푸들", 3
        p2.name = "나비"; p2.species = "코리안숏헤어"; p2.age=5; // (3) 두 번째 객체에는 "나비", "코리안숏헤어", 5
        // (4) "이름: [이름], 종류: [품종], 나이: [나이]살" 형식 출력
        System.out.printf("이름 : %s , 종류 : %s , 나이 : %d살 \n" ,
                                p1.name , p1.species, p1.age);
        System.out.printf("이름 : %s , 종류 : %s , 나이 : %d살 \n" ,
                                p2.name , p2.species, p2.age);

        Rectangle R1 = new Rectangle(); // 객체 생성
        R1.width = 10; R1.height = 5;   // 객체내 멤버변수에 값 저장
        System.out.println("사각형의 넓이: "+R1.width*R1.height);

        BankAccount bank1 = new BankAccount(); // 객체 생성
        bank1.accountNumber = "111-222-3333"; bank1.ownerName= "유재석"; bank1.balance=10000;
        bank1.balance += 5000;
        System.out.println("입금 후 잔액: "+ bank1.balance);
        bank1.balance -= 3000;
        System.out.println("출금 후 잔액: "+ bank1.balance);

        Product pr1 = new Product();
        Product pr2 = new Product();
        pr1.name = "새우깡"; pr1.price =1500; pr2.name = "콜라"; pr2.price = 2000;
        if(pr1.price > pr2.price) {
            System.out.println(pr1.name);
        }else{System.out.println(pr2.name);}

    Member user1 = new Member();
        user1.ID = "admin"; user1.isLogin = false;
        System.out.println("로그인 전 상태: " +user1.isLogin);
        user1.isLogin = true;
        System.out.println("로그인 후 상태 : " +user1.isLogin);

        Television tv1 = new Television();
        tv1.channel = 7; tv1.volume = 20;
        tv1.channel = 11; tv1.volume-=2;
        System.out.println(tv1.channel);
        System.out.println(tv1.volume);

        Player player1 = new Player();
        Player player2 = new Player();

        player1.name = "손흥민"; player1.power = 90; player1.speed = 95;
        player2.name = "이강인"; player2.power = 85; player2.speed = 92;
        if( (player1.power + player1.speed) > (player2.power + player2.speed) ) {
            System.out.println(player1.name);
        }else{
                System.out.println(player2.name);
            }

        MenuItem item1 = new MenuItem();
        MenuItem item2 = new MenuItem();
        MenuItem item3 = new MenuItem();
        item1.name = "김치찌개"; item1.price= 8000; item1.isSignature=true;
        item2.name = "된장찌개"; item2.price= 8000; item2.isSignature=false;
        item3.name = "계란찜"; item3.price= 3000; item3.isSignature=false;
        MenuItem[] items = {item1, item2, item3 };
        for( int i=0; i<=items.length-1  ; i++){
            if(items[i].isSignature == true ){
                System.out.println("[대표메뉴] ["+items[i].name+"] : [가격]"+items[i].price+"원");}// if end
        }// for end



    UserProfile user = new UserProfile();

        Scanner scan = new Scanner(System.in);
        System.out.println("이름 입력: ");
        String name1 = scan.next();
        System.out.println("나이 입력: ");
        int age1 = scan.nextInt();
        System.out.println("MBTI 입력: ");
        String mbti1 = scan.next();

        user.name=name1; user.age=age1; user.mbti=mbti1;
        System.out.println("--- 프로필 ---");
        System.out.println("이름: " + name1);
        System.out.println("나이: " + age1);
        System.out.println("MBTI: " + mbti1);



    }   // main end

}   // class end

//        JAVA] 실습7 : 클래스와 객체의멤버변수
//[ 문제 ] 아래 클래스와 멤버변수 관련 문제
//                [ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.
//
//[문제 1] Book 클래스를 만드세요. 이 클래스는 title(문자열), author(문자열), price(정수) 멤버 변수를 가집니다.
//        1. main 함수에서 Book 객체 2개를 생성하세요.
//        2. 첫 번째 객체에는 "이것이 자바다", "신용권", 30000을, 두 번째 객체에는 "자바의 정석", "남궁성", 28000을 각각 저장하세요.
//        3. 두 객체의 모든 정보를 각각 출력하세요.
//
//[문제 2] Pet 클래스를 만드세요. name(문자열), species(문자열, 품종), age(정수) 멤버 변수를 가집니다.
//        1. main 함수에서 Pet 객체 2개를 생성하세요.
//        2. 첫 번째 객체에는 "초코", "푸들", 3을, 두 번째 객체에는 "나비", "코리안숏헤어", 5를 각각 저장하세요.
//        3. "이름: [이름], 종류: [품종], 나이: [나이]살" 형식으로 각 반려동물의 프로필을 출력하세요.
//
//[문제 3] Rectangle 클래스를 만드세요. width(정수)와 height(정수) 멤버 변수를 가집니다.
//        1. main 함수에서 Rectangle 객체를 하나 생성하고, width에 10, height에 5를 저장하세요.
//        2. 해당 객체의 width와 height 값을 곱하여 "사각형의 넓이: [넓이]"를 출력하세요.
//
//[문제 4] BankAccount 클래스를 만드세요. accountNumber(문자열), ownerName(문자열), balance(정수, 잔액) 멤버 변수를 가집니다.
//        1. main 함수에서 BankAccount 객체를 하나 생성하고, 계좌번호는 "111-222-3333", 예금주는 "유재석", 초기 잔액은 10000으로 저장하세요.
//        2. balance에 5000을 더하여 입금 상황을 구현하고, "입금 후 잔액: [잔액]"을 출력하세요.
//        3. 다시 balance에서 3000을 빼서 출금 상황을 구현하고, "출금 후 잔액: [잔액]"을 출력하세요.
//
//[문제 5] Product 클래스를 만드세요. name(문자열)과 price(정수) 멤버 변수를 가집니다.
//        1. main 함수에서 Product 객체 2개를 생성하고, 각각 "새우깡", 1500과 "콜라", 2000 정보를 저장하세요.
//        2. if문을 사용하여 두 객체의 price를 비교하고, 더 비싼 상품의 이름을 출력하세요.
//
//[문제 6] Member 클래스를 만드세요. id(문자열)와 isLogin(boolean) 멤버 변수를 가집니다.
//        1. main 함수에서 Member 객체를 하나 생성하고, 아이디는 "admin", isLogin은 false로 초기화하세요.
//        2. "로그인 전 상태: [isLogin 값]"을 출력하세요.
//        3. 객체의 isLogin 값을 true로 변경하여 로그인 상황을 구현하세요.
//        4. "로그인 후 상태: [isLogin 값]"을 출력하세요.
//
//[문제 7] Television 클래스를 만드세요. channel(정수)과 volume(정수) 멤버 변수를 가집니다.
//        1. main 함수에서 Television 객체를 생성하고, channel은 7, volume은 20으로 초기화하세요.
//        2. 객체의 channel 값을 11로 변경하고, volume 값은 2 감소시킨 뒤, 변경된 채널과 볼륨을 출력하세요.
//
//[문제 8] Player 클래스를 만드세요. name(문자열), power(정수), speed(정수) 멤버 변수를 가집니다.
//        1. main 함수에서 Player 객체 2개를 생성하세요.
//        2. 첫 번째 객체에는 "손흥민", 90, 95를, 두 번째 객체에는 "이강인", 85, 92를 각각 저장하세요.
//        3. 두 객체의 power와 speed의 합을 각각 계산하고, 합이 더 높은 선수의 이름을 출력하세요.
//
//[문제 9] MenuItem 클래스를 만드세요. name(문자열), price(정수), isSignature(boolean, 대표메뉴 여부) 멤버 변수를 가집니다.
//        1. main 함수에서 MenuItem 객체 3개를 생성하고, 첫 번째는 "김치찌개", 8000, true, 두 번째는 "된장찌개", 8000, false, 세 번째는 "계란찜", 3000, false로 저장하세요.
//        2. if문을 사용하여 isSignature가 true인 메뉴 객체를 찾아, "[대표메뉴] [메뉴이름] : [가격]원" 형식으로 출력하세요.
//
//[문제 10] UserProfile 클래스를 만드세요. name(문자열), age(정수), mbti(문자열) 멤버 변수를 가집니다.
//        1. main 함수에서 UserProfile 객체를 하나 생성하세요.
//        2. Scanner를 사용하여 사용자로부터 이름, 나이, MBTI를 순서대로 입력받으세요.
//        3. 입력받은 값들을 생성된 객체의 각 멤버 변수에 저장하세요.
//        3. 모든 정보가 저장된 객체의 멤버 변수들을 가져와 "--- 프로필 ---", "이름: [이름]", "나이: [나이]", "MBTI: [MBTI]" 형식으로 출력하세요.
//

