package day15;

public interface Device {
    public abstract void turnOn();
    void turnOff(); // 추상 키워드 생략

    public default void setMute(boolean mute){
        System.out.println("무음 처리합니다.");
    }
}
class Television implements Device{
    @Override
    public void turnOn() {
        System.out.println(" TV on");

    }
    @Override
    public void turnOff() {
        System.out.println(" TV off");

    }
}