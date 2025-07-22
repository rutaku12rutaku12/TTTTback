package day17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Data Access Object : 데이터(데이터베이스/파일) 접근 객체
public class Dao {
    // (!) 싱글톤
    private Dao(){
        // Dao객체가 생성될때 DB연동
        connectDB();
    }
    private static final Dao instance = new Dao();
    public static Dao getInstance(){
        return instance;}
    // (!) DB연동 에 필요한 정보
    String db_url ="jdbc:mysql://localhost:3306/mydb0722";
    String db_user ="root";
    String db_password ="1234";
    Connection conn;    // DB연동 결과를 갖는 인터페이스
    // (1) 연동 함수
    public void connectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // mysql 드라이버/클래스 로드 함수
            conn = DriverManager.getConnection(db_url,db_user,db_password);
            System.out.println("데이터 베이스 연동 성공");
        }catch (ClassNotFoundException e){System.out.println("mysql 드라이버 연동 실패");}
        catch (SQLException e ){System.out.println("데이터베이스 연동 실패");}
    } // func end


} // class end

