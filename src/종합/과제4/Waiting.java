package 종합.과제4;

public class Waiting { // class start
    // 1) 멤버변수
    private String phone;
    private int count;
    // 2) 생성자
        // 기본생성자
    public  Waiting(){}
        // 전체매개변수를 갖는 생성자
    public Waiting(String phone, int count) {
        this.phone = phone;
        this.count = count;
    }
    // 3) 메소드
    // private로 선언된 멤버변수를 외부에서 사용하기 위해 getter/setter로 지원
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    // 객체 주소값을 문자열로 반환
    @Override
    public String toString() {
        return "Waiting{" +
                "phone='" + phone + '\'' +
                ", count=" + count +
                '}';
    }
} // class end
