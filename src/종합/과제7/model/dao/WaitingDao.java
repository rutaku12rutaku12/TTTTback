package 종합.과제7.model.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import 종합.과제7.model.dto.WaitingDto;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WaitingDao {
    // (*) 싱글톤
    private WaitingDao(){
        openCSV(); // 싱글톤 생성시 CSV 오픈
        connectDB();
    }
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance(){
        return instance;
    }

    // (!) DB 연동에 필요한 정보
    String db_url = "jdbc:mysql://localhost:3306/mydb0722";
    String db_user= "root";
    String db_password= "1234";
    Connection conn; // DB 연동 결과를 갖는 인터페이스
    // (1) db 연동함수
    public void connectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // mysql 드라이버/클래스 로드함수
            conn = DriverManager.getConnection(db_url, db_user, db_password);
            System.out.println("데이터 베이스 연동 성공");

            // 자바에서 테이블 생성
            String sql = "insert into waiting(phone,count) values('010-8234-3508','4')"; // SQL 작성
            PreparedStatement ps = conn.prepareStatement( sql ); // 지정한 SQL을 연동된 인터페이스에 대입
            ps.execute(); // 기재된 SQL 실행
        }catch (ClassNotFoundException e){
            System.out.println(" 연동 실패1 ");
        }catch (SQLException e){
            System.out.println("연동 실패2");
        }
    }// func end

    // (*) DB 대신할 리스트 선언
    ArrayList<WaitingDto> waitingDB = new ArrayList<>();

    // (1) 등록
    public boolean addWaiting(WaitingDto waitingDto){
        waitingDB.add( waitingDto ); // 1. db에 DTO를 저장한다.
        saveCSV(); // * CSV 저장
        return true; // 2. 성공시 true 반환
    }


    // (2) 전체조회
     public  ArrayList<WaitingDto> getWaitingList(){
        // ArrayList<WaitingDto> : 반환타입으로 모든 dto를 반환한다.
         return waitingDB;
     }// func end

    // (*) CSV 파일 경로 지정한다.
    private String path = "src/종합/과제7/data.csv";
    // ---------------------- 1. CSV 파일 연동 함수
    public void openCSV(){
        File file = new File(path); // (1) 파일 객체 생성
        if( file.exists()) { // (2) 만약에 파일이 존재하면 정보 불러오기
            loadCSV();

        }else{ // (2) 아니면 파일 생성
            try {
                file.createNewFile(); // 파일 생성 , 예외 처리
            } catch (IOException e) {
                System.out.println(e);
            }
        }

    } // func end
    // --------------- 2. CSV 입력(호출) 함수
    public void loadCSV(){
        try {
            // (1) FileReader 이용한 읽기모드 객체 생성
            FileReader fileReader = new FileReader(path);
            // (2) CSVReader 에 FileReader 대입하여 CSV객체 생성
            CSVReader csvReader = new CSVReader(fileReader);
            // (3) .readAll() 함수로 모든 CSV 정보를 읽어온다.
            List<String[]> inData = csvReader.readAll();
            // (4) 반복문 이용한 행 순회
            for (String[] row : inData) {
                String phone = row[0]; // 첫 번째 열
                String count = row[1]; // 두 번째 열
                // (5) 각 열들을 하나의 dto로 생성
                WaitingDto waitingDto = new WaitingDto(phone, count);
                // (6) 생성된 dto를 리스트에 저장
                waitingDB.add(waitingDto);
            } // for end
            //(7) 안전하게 닫기
            csvReader.close();
        } catch (Exception e ){
            System.out.println(e);
        }
    } // func end

    // ------------- 3. CSV 출력(저장) 함수
    public void saveCSV(){
        try {
            // (1) FileWriter 파일 쓰기모드 객체 생성
            FileWriter fileWriter = new FileWriter(path);
            // (2) CSVWriter 에 filewriter 객체를 대입하여 생성
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            // (3) 빈 리스트 생성
            List<String[]> outData = new ArrayList<>();
            // ArrayList(구현체) , List(인터페이스)
            // (4) 현재 모든 정보를 outData에 담아준다.
            for (WaitingDto waitingDto : waitingDB) {
                // (5) dto 하나씩 내용과 작성자를 배열 로 구성
                String[] row = {waitingDto.getPhone(),
                        waitingDto.getCount()};
                // (6) outData에 저장한다.
                outData.add(row);
            } // for end
            // (7) 최종적으로 outData를 CSV 내보내기 한다.
            csvWriter.writeAll(outData);
            csvWriter.close(); // (8) 안전하게 객체 닫기
        }catch (Exception e){
            System.out.println(e);
        }

    } // func end

} // class end




















