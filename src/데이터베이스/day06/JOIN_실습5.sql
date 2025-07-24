# 1. 데이터베이스 생성
drop database if exists mydb0724; 	-- 존재시 삭제
create database mydb0724;			-- 데이터베이스 생성
use mydb0724;						-- 데이터베이스 사용, 워크벤치 재실행후에도

# 2. 테이블 생성
create table table1(					-- 'table1' 테이블 생성
	num_pk int,							-- 'num_pk' 속성/컬럼/필드 int 타입 선언
    constraint primary key ( num_pk )	-- 선언된 'num_pk' 속성을 pk(식별키) 설정
);  # PRIMARY KEY : 식별키 , 중복 불가능 , NULL 불가능 , 고유한 값 , 게시물번호/회원번호/학번/제품번호 등등

# 3. 테이블 생성 
create table table2(
	no_pk int ,
    constraint primary key ( no_pk ) ,
    num_fk int , 
        -- 선언된 'num_fk' 속성을 fk(참조키) 설정  -- 'table1' 테이블의 'num_pk' 를 참조
    constraint foreign key ( num_fk ) references table1 ( num_pk ) 
    on update cascade -- 만약에 table1의 'num_pk' 값이 수정되면 'num_fk' 값도 같이 수정
    on delete cascade -- 만약에 table1의 'num_pk' 값이 삭제되면 'num_fk' 값도 같이 삭제
		/* 참조 옵션 : constraint Foreign key( fk필드 ) references 테이블명 ( pk필드 ) 옵션
			on [ update /delete ] [ cascade / set null / restrict ]
			1. on delete cascade : 참조중인 pk 레코드가 삭제되면 같이 fk 레코드 도 같이 삭제한다.
            2. on update cascade : 참조중인 pk 레코드의 pk값이 변경되면 fk 값도 같이 변경된다.
            3. on delete set null : 참조중인 pk 레코드가 삭제되면 fk 값은 null로 변경된다.
            4. on update set null : 참조중인 pk 레코드의 pk값이 변경되면 fk 값은 null로 변경된다.
            5. on delete restrict : (기본값/생략) pk가 참조중인 pk레코드는 삭제 불가능 설정한다. 
            6. on update restrict : (기본값/생략) pk가 참조중인 pk레코드는 수정 불가능 설정한다. 
				* 단 restrict 에서 pk값을 참조하는 fk값이 존재하지 않으면 삭제/수정 가능
            
        */
); # FOREIGN KEY : 참조키 , 중복 가능 , NULL 가능 , 참조값 , 댓글이위치한게시물번호/게시물작성자번호/수강신청학생번호/주문한제품번호

# 실생활 : 우리집의 집주소 pk , 쿠팡/지마켓/카카오쇼핑 에서 우리집주소 FK 등록
# 집주소는 하나만 존재하고 각 쇼핑몰은 집주소를 참조한다.

# 왜 ? PK 와 FK 참조(관계)형 테이블 = 관계형 데이트베이스 RDBMS
# 3. 서로 다른 테이블 합치기 = JOIN , # PK레코드와 FK레코드를 하나의 테이블로 조회
# 샘플 데이터
insert into table1 values(1) , (2) , (3) , (4) , (5);
insert into table2 values( 1 , 1 ) , ( 2 , 2 ) , ( 3 , 1 ) , ( 4 , 1 ) , ( 5 , 2 );
# 레코드 조회
select * from table1;
select * from table2;
# (1) 두개 이상의 테이블 조회하기 : select * from 테이블명A , 테이블명B , 테이블명C;
# 주의할점 : 두 테이블간의 데카르트 곱 으로 표현 된다. 테이블명A(5개) 테이블명B(5개) 5*5 = 25개 레코드
select * from table1 , table2;
# (2) 교집합 : 두 테이블간의 공통된 값(PK-FK) 기준으로 레코드 조회
# 2-1) where 절 , 일반적으로 join과 조건절 구분이 어렵기 때문에 실무 사용불가능.
select * from table1 , table2 where table1.num_pk = table2.num_fk;

# 2-2) inner join on 절 , 테이블A inner join 테이블B on 테이블A.PK속성명=테이블B.FK속성명
select * from table1 inner join table2 on table1.num_pk = table2.num_fk;
# WHERE 일반조건 , HAVING 그룹조건 , ON 집합조건

# 2-3) inner 생략 가능 , 테이블에 as 별칭 가능 , 조인 결과에서 원하는 속성명만 조회
select * from table1 join table2 on table1.num_pk = table2.num_fk;
select * from table1 AS t1 INNER JOIN table2 t2 ON t1.num_pk = t2.num_fk; 
SELECT t1.num_pk AS 식별키 , t2.num_fk 참조키 FROM table1 t1 INNER JoIN table2 t2 ON t1.num_pk = t2.num_fk;

# 아래 키워드 전제조건 : pk속성명 과 fk속성명이 일치할때만 가능하다.
# 2-4) natural join : 자연조인 , 조인 의도 와 다르게 동일한 속성명이 존재할 수 있으므로 비권장*
SELECT * FROM table1 natural join table2;
# 2-5) join using : 현재 두테이블간의 동일한 pk-fk속성명이 아니므로 불가능*
select * from table1 join table2 using( num_pk );

# (3) OUTER JOIN
# 3-1) LEFT OUTER JOIN ON :왼쪽 테이블(table1) 에 있는 모든 레코드 와 오른쪽 테이블(table2)에 교집합 되는 레코드 조회 , 없으면 null
# 왼쪽 테이블의 레코드 전체 조회 + 오른쪽 테이블과 교집합 레코드 값 표현 되고 없으면 null
select * from table1 t1 left outer join table2 t2 ON t1.num_pk = t2.num_fk;
# 3-2) RIGHT OUTER JOIN ON : 오른쪽 테이블(table1) 에 있는 모든 레코드 와 왼쪽 테이블(table2)에 교집합 되는 레코드 조회 , 없으면 null
# 오른쪽 테이블의 레코드 전체 조회 + 왼쪽 테이블과 교집합 레코드 값 표현 되고 없으면 null
select * from table1 t1 right outer join table2 t2 on t1.num_pk = t2.num_fk;
# 3-3) OUTER 생략가능
select * from table1 t1 left join table2 t2 on t1.num_pk =t2.num_fk;

# (4) 합집합,  MYSQL : UNION , ORACLE : FULL OUTER JOIN
# 4-1) UNION : 2개 이상의 SELECT를 하나로 합치기 , LEFT OUTER +(UNION)+ RIGHET OUTER
SELECT * FROM table1 t1 left join table2 t2 on t1.num_pk =t2.num_fk union
SELECT * FROM table1 t1 right join table2 t2 on t1.num_pk =t2.num_fk;

# (5) 차집합 : LEFT OUTER JOIN 에서 교집합(공통pk-fk) 제외한 
# 5-1) 왼쪽 테이블(table1) 의 차집합 ( 교집합 외 나머지 레코드 )
select t1.* from table1 t1 left join table2 t2 on t1.num_pk =t2.num_fk where t2.num_fk is null; 
# 5-2) 오른쪽 테이블(table2) 의 차집합 ( 교집 외 나머지 레코드 )
select t2.* from table1 t1 right join table2 t2 on t1.num_pk =t2.num_fk where t1.num_pk is null;

/* 
	교집합 : 두 테이블간의 테이블A의 PK 레코드와 테이블B의 FK 값이 *동일*한 레코드 를 하나의 테이블로 조회
		1. where
        2. inner join on 
        3. join on  (inner생략)
        4. natural join (pk ,fk 이름 동일해야함)
        5. using join 	(pk ,fk 이름 동일해야함)
    차집합 : 두 테이블간의 하나의 테이블A 레코드를 제외한 하나의 테이블B 의 레코드 조회
		A-B : select 테이블A.* from 테이블A left outer join 테이블B on 테이블A.PK = 테이블B.FK where 테이블B.FK in null
    합집합 : 두 테이블간의 모든 레코드를 하나의 테이블로 조회
		ORACLE DB : FULL OUTER JOIN 
        MYSQL DB : LEFT OUTER JOIN *UNION* RIGHT OUTER JOIN
*/

-- [SQL] 실습5 : JOIN 실습 문제
-- [ 문제 ] 아래 SQL JOIN 관련 문제를 해결하시오.
-- [ 제출방법 ] 각 문제의 요구사항에 맞는 SQL 코드를 작성하여 제출하시오.
-- [사전 준비] 실습용 데이터베이스 및 테이블, 데이터 생성
-- 아래 SQL 코드를 전체 복사하여 MySQL Workbench에서 실행(Ctrl+Shift+Enter)한 후 문제를 풀어주세요.
-- ==================== 실습 환경 구축 ====================
DROP DATABASE IF EXISTS exam5;
CREATE DATABASE exam5;
USE exam5;
-- 1. 카테고리 테이블
CREATE TABLE pcategory(
    카테고리번호_pk INT UNSIGNED AUTO_INCREMENT,
    카테고리명 VARCHAR(10) NOT NULL,
    PRIMARY KEY(카테고리번호_pk)
);
-- 2. 제품 테이블
CREATE TABLE product(
    제품번호_pk INT UNSIGNED AUTO_INCREMENT,
    제품명 VARCHAR(100) NOT NULL,
    제품가격 INT UNSIGNED NOT NULL,
    카테고리번호_fk INT UNSIGNED,
    PRIMARY KEY(제품번호_pk),
    FOREIGN KEY(카테고리번호_fk) REFERENCES pcategory(카테고리번호_pk)
);
-- 3. 재고 테이블
CREATE TABLE stock(
    재고번호_pk INT UNSIGNED AUTO_INCREMENT,
    재고수량 INT,
    재고등록날짜 DATETIME DEFAULT NOW(),
    제품번호_fk INT UNSIGNED,
    PRIMARY KEY(재고번호_pk),
    FOREIGN KEY(제품번호_fk) REFERENCES product(제품번호_pk)
);

-- 샘플 데이터 삽입
INSERT INTO pcategory(카테고리명) VALUES('노트북'), ('스마트폰'), ('의류'), ('도서');
INSERT INTO product(제품명, 제품가격, 카테고리번호_fk) VALUES
('그램 15인치', 1500000, 1), ('맥북 프로 16인치', 3000000, 1),
('갤럭시 S23', 1200000, 2), ('아이폰 14 Pro', 1550000, 2),
('반팔 티셔츠', 30000, 3), ('청바지', 80000, 3),
('혼공 SQL', 22000, 4);
INSERT INTO stock(재고수량, 제품번호_fk) VALUES (10, 1), (5, 2), (20, 3), (15, 4), (100, 5), (50, 6),(5, 1), (2, 3);

-- ========================================================
-- [문제 1] 모든 제품의 제품명과 해당 제품의 카테고리명을 함께 조회하세요. (조회결과: 7개 레코드)
-- JOIN 필요한 이유 : 제품명 과 카테고리명 은 서로 다른 테이블에 존재한다. 즉] 서로 다른 테이블을 하나로 집합 해야한다.
-- !! JOIN 조건 : 서로 다른 테이블간의 동일한 속성값이 필요하다. 주로] PK의 FK속성이 주로 같은 값을 갖는다.
-- 1. 제품명이 존재하는 테이블 조회
select * from product p;			-- 1. 제품명 존재하는 테이블 조회
select * from pcategory pc; 		-- 2. 카테고리명 존재하는 테이블 조회
select * from product p , pcategory pc; 		-- *. 서로 다른 두 테이블을 한번에 조회 (교집합 X) 크로스 테이블
-- 3. 교집합 ( 두 집합[테이블] 간의 공통 , 주로 pk와fk )
select * from product p inner join pcategory pc on p.카테고리번호_fk = pc.카테고리번호_pk;
-- 4. 교집합 이후 원하는 속성명 추출
select p.제품명,pc.카테고리명 from product p join pcategory pc on p.카테고리번호_fk = pc.카테고리번호_pk;

-- [문제 2] '노트북' 카테고리에 속하는 모든 제품의 제품명과 제품가격을 조회하세요. (조회결과: 2개 레코드)
select p.제품명,p.제품가격 from product p join pcategory pc on p.카테고리번호_fk = pc.카테고리번호_pk where pc.카테고리명='노트북';
-- [문제 3] 모든 제품의 제품명과 등록된 재고수량을 함께 조회하세요. (조회결과: 8개 레코드)
select * from stock;
select * from product;
select * from stock s join product p on p.제품번호_pk = s.제품번호_fk;
select p.제품명, s.재고수량 from stock s join product p on p.제품번호_pk = s.제품번호_fk;

-- [문제 4] '그램 15인치' 제품의 모든 재고등록날짜와 재고수량을 조회하세요. (조회결과: 2개 레코드)

select * from stock;
select * from product;
select * from stock s join product p on p.제품번호_pk = s.제품번호_fk;
select s.재고등록날짜,s.재고수량 from stock s join product p on p.제품번호_pk = s.제품번호_fk where p.제품명='그램 15인치'; 

-- [문제 5] 모든 제품의 제품명, 카테고리명, 재고수량을 한 번에 조회하세요. (3개 테이블 조인) (조회결과: 8개 레코드)
select * from product p;
select * from pcategory pc;
select * from stock s;
select * from product p join pcategory pc on p.카테고리번호_fk = pc.카테고리번호_pk join stock s on p.제품번호_pk = s.제품번호_fk ;
select p.제품명,pc.카테고리명,s.재고수량 from product p join pcategory pc on p.카테고리번호_fk = pc.카테고리번호_pk join stock s on p.제품번호_pk = s.제품번호_fk ;

-- [문제 6] 모든 카테고리의 카테고리명과 해당 카테고리에 속한 제품명을 조회하세요. 만약 카테고리에 속한 제품이 없더라도 카테고리명은 모두 표시되도록 하세요. (조회결과: 7개 레코드)
select * from pcategory pc;
select * from product p;
select * from pcategory pc inner join product p on pc.카테고리번호_pk = p.카테고리번호_fk ;
select pc.카테고리명,p.제품명 from pcategory pc left join product p on pc.카테고리번호_pk = p.카테고리번호_fk ; -- 모르겟슴 ㅇㅅㅇ;
-- [문제 7] 재고가 한 번도 등록되지 않은 제품의 제품명을 조회하세요. (조회결과: 1개 레코드)
select * from stock s;
select * from product p;
select * from product p inner join stock s on p.제품번호_pk = s.제품번호_fk;
select p.제품명, s.제품번호_fk  from product p left join stock s on p.제품번호_pk = s.제품번호_fk;

-- [문제 8] 각 카테고리별로 총 재고 수량의 합계를 카테고리명과 함께 조회하세요. (조회결과: 3개 레코드)
select * from stock s;
select * from product p;
select * from pcategory pc;
select * from pcategory pc join product p on pc.카테고리번호_pk = p.카테고리번호_fk join stock s on p.제품번호_pk = s.제품번호_fk;
select pc.카테고리명, sum(s.재고수량) from pcategory pc join product p on pc.카테고리번호_pk = p.카테고리번호_fk join stock s on p.제품번호_pk = s.제품번호_fk group by pc.카테고리명;

-- [문제 9] 각 제품별로 총 재고 수량을 조회하고, 총 재고 수량이 많은 순서대로 정렬하여 제품명과 총재고수량을 표시하세요. (조회결과: 6개 레코드)
select * from stock s;
select * from product p;
select * from pcategory pc;
select * from pcategory pc join product p on pc.카테고리번호_pk = p.카테고리번호_fk join stock s on p.제품번호_pk = s.제품번호_fk;
select p.제품명, sum(s.재고수량) from pcategory pc join product p on pc.카테고리번호_pk = p.카테고리번호_fk join stock s on p.제품번호_pk = s.제품번호_fk group by p.제품명 order by sum(s.재고수량) desc ;






