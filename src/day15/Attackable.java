package day15;

public interface Attackable {
    public abstract void attack(); // 공격!
}

class Sword implements Attackable{
    @Override
    public void attack() {
        System.out.println("검 공격 실행");
    }
}
class Gun implements Attackable{
    @Override
    public void attack() {
        System.out.println("총 공격 실행");
    }
}
class Character {
    void useWeapon(Attackable weapon){
        weapon.attack();
    }
}