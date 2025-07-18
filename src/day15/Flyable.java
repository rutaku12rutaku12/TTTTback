package day15;

public interface Flyable {
    public abstract void fly(); // 하늘을 납니다.
}

interface Swimmable {
    public abstract void swimmable(); // 물에서 헤엄칩니다.
}

class Duck implements Flyable,Swimmable {
    @Override
    public void fly() {
        System.out.println("오리가 날다");
    }
    @Override
    public void swimmable() {
        System.out.println("오리가 헤엄치다");
    }
}