package day09;

public class BankAccount {
    // 1.멤버변수
    private String accountNumber;
    // 2. 생성자
    // * 오른쪽클린 -> [생성] -> [생성자]
    BankAccount( String accountNumber ){
        this.accountNumber = accountNumber;
    }
    // 3. 메소드
    // 1) getter 메소드
    public String getAccountNumber(){
        return this.accountNumber;
    }

} // class end
