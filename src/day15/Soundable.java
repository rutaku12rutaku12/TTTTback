package day15;

public interface Soundable {
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