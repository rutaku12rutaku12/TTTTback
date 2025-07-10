package 종합.예제6;

// (1) 데이터 모델 : 게시물 모델링
// 데이터를 객체로 갖는
public class Board { // class start
    // 1. 멤버변수 : 주로 멤버변수는 private 한다. * 모델링에 들어갈 속성
    private String content;
    private String writer;
    // 2. 생성자 : *관례적* 기본생성자1개 와 전체매개변수갖는 생성자1개 한다. (2개)
    // 자동 : 해당 클래스에서 오른쪽클릭 -> [생성] -> [생성자] -> 모든 멤버변수 복수선택(ctrl or shift)후 -> [확인]
    // 1) 기본생성자
    public Board(){}
    // 2) 전체매개변수를 갖는 생성ㅈ아
    public Board(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }

    // 3. 메소드 :
    // 1) private 으로 선언된 멤버변수를 외부(다른클래스)로부터 접글할수 있도록 getter/setter 지원한다.
    // 자동 : 해당 클래스에서 오른쪽 -> [생성] -> [getter 및 setter] -> 모든 멤버변수 복수선택후 -> [확인]
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    // 2) 개발자가 작업하면서 객체의 주소값이 아닌 객체내 멤버변수 값을 문자열로 반환 , toString() 지원한다.
    // 자동 : 해당 클래스에서 오른쪽 클릭 -> [생성] - > [toString] -> 모든 멤버변수 복수선택후 -> [확인]
    @Override
    public String toString() {
        return "Board{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
} // class end
