package 종합.예제8.model.dto;

public class BoardDto {
    // 1. 멤버변수 : 데이터 모델링의 속성 참고 , private(데이터 간접보호)
    private String content; // 내용
    private String writer; // 작성자

    // 2. 생성자

    public BoardDto() {
    }

    public BoardDto(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }

    // 3. 메소드
    // getter and setter , toString
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

    @Override
    public String toString() {
        return "BoardDto{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
} // class end
