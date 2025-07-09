package day08;

public class Rectangle {
    // 멤버변수
    int width;
    int height;
    // 생성자 : width 와 height를 매겨변수로 받아
    Rectangle( int width , int height){
        // 초기화하는 생성자
        this.width = width;
        this.height = height;
    }
    // 메소드 :
    // 1. 메소드명 : getArea
    // 2. 매개변수 : x
    // 3. 반환값 :  곱한 계산결과 , int result;
    int getArea(){
        // 멤버변수( getArea() 메소드를 호출된 객체내 ) 끼리 계산
        int result = width * height;
        // 결과 반환
        return result;
    } // func end
} // class end
