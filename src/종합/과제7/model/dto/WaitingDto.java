package 종합.과제7.model.dto;

public class WaitingDto {
    // 1. 멤버변수
    // 1) private
    private String Phone;
    private String count;

    // 2. 생성자
    // 1) 기본생성자

    public WaitingDto() {
    }

    // 2) 전체생성자

    public WaitingDto(String phone, String count) {
        this.Phone = phone;
        this.count = count;
    }



    // 3. 메소드
    // 1.) setter
    // 2.) getter

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
    // 3.) toString

    @Override
    public String toString() {
        return "WaitingDto{" +
                "Phone='" + Phone + '\'' +
                ", count=" + count +
                '}';
    }
}
