package day09;

public class TicketMachine {
    // 1.멤버변수
    static int totalTickets = 0;
    // 2. 생성자
    // 3. 메소드
    public int issueTicket(){
        System.out.println("티켓 1장을 발권했습니다.");
        return totalTickets++;
    }
    static void printTotalTicket(){
        System.out.println("총 발권수 "+totalTickets+"장");
        return;
    }
}
