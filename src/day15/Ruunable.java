package day15;

interface Runnable {
    public abstract void run(); // 달립니다.
}

class Person implements Runnable{
    @Override
    public void run() {
        System.out.println("사람이 달립니다.");

    }
}
class Car implements Runnable{
    @Override
    public void run() {
        System.out.println("자동차가 달립니다.");

    }
}