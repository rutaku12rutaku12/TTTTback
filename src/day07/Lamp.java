package day07;

public class Lamp {
    boolean isOn; // 멤버변수

    void turnOn(){
       isOn= true;
        System.out.println(isOn);
    }
    void turnOff(){
        isOn= false;
        System.out.println(isOn);
    } // func end
} // class end
