package day12.model.dao;

import day12.model.dto.UserDto;

import java.util.ArrayList;

public class UserDao {

    // 싱글톤

    // [1] 회원가입
    //

    //[*]
    private ArrayList<UserDto> userDB = new ArrayList<>();
    private int uno = 0 ; // 회원번호 ( add 할때마다 1씩 증가 )

//    public int 회원가입( String uid ,String upwd , String uname , String uphone ) {
//        // (0) 회원번호
//        uno++;
//        // (1) 입력받은 값들을 객체화
//        UserDto userDto = new UserDto( uno , uid , upwd , uname , uphone ){
//        // (2) db에 저장
//        userDB.add( userDto );
//        // (3) 성공시
//        return 0;
//
//        }
//    }
//
//    // [2] 로그인
//    int 로그인( String uid ,String upwd ){
//        System.out.println("UserDao.로그인"); // sout m
//        System.out.println("uid = " + uid + ", upwd = " + upwd); // sout p
//
//        // (1) DB 조회(순회)
//        for( int i = 0 ; i < userDB.size(); i++){
//            UserDto userDto = userDB.get(i);
//            // (2) 비교
//            if( userDto.getUid().equals( uid ) && userDto.getUpwd().equals( upwd ) ){
//                retrun 0;
//            }
//        }
//        return 1;
//    }
}

