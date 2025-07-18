package day15;

public interface DataAccessObject {
    public abstract void save(); // 데이터를 저장합니다.
}
class OracleDao implements DataAccessObject{
    @Override
    public void save() {
        System.out.println("Oracle DB에 저장");
    }
}
class MySqlDao implements DataAccessObject{
    @Override
    public void save() {
        System.out.println("MySQL DB에 저장");
    }
}
