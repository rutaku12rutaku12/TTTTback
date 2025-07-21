package day15;

public interface Soundable {
    // 인터페이스 주요 멤버 : 상수 , 추상메소드 : 구현부{}없는 메소드
     public abstract void makeSound(); // 소리를 냅니다
}
class Cat implements Soundable{
    @Override
    public void makeSound() {
        System.out.println("야용");
    }
}
class Dog implements Soundable{
    @Override
    public void makeSound() {
        System.out.println("멍멍");

    }
}