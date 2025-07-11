package 종합.과제5.model.dto;

// 데이터 모델 , 이동객체
public class WaitingDto { // class start
    // 1. 멤버변수 : 모두 private 한다.
    private String phone;
    private int count;
    // 2. 생성자 :
        // 기본생성자
    public WaitingDto(){
    }
        // 풀생성자
    public WaitingDto(String phone, int count) {
        this.phone = phone;
        this.count = count;
    }
    // 3. 1)getter and setter
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
        // 2) toString
    @Override
    public String toString() {
        return "WaitingDto{" +
                "phone='" + phone + '\'' +
                ", count=" + count +
                '}';
    }
} // class end
