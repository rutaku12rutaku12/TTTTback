# SQL 연산자
drop database if exists mydb0717;
create database mydb0717;
use mydb0717;

# 1. 회원테이블
create table member(            # 아이돌 그룹
   mid char(8) not null ,         # 식별키       최대 8자리
    mname varchar(10) not null ,   # 그룹명      최대 10자리
    mnumber int not null ,         # 인원수      정수 +-21억정도
    maddr char(2) not null ,       # 지역      최대 2자리
    mphone1 char(3) ,            # 지역번호   최대 2자리
    mphone2 char(8) ,            # 전화번호    최대 8자리
    mheight smallint ,            # 평균키       정수 +-3만정도
   mdebut date ,               # 데뷔일       yyyy-mm-dd
    constraint primary key ( mid )            # 제약조건
);
# 2. 구매테이블
create table buy(
   bnum int auto_increment ,          # 구매번호   정수    자동번호 부여
    mid char(8),                  # 구매자      FK
    bpname char(6) not null ,         # 제품명      최대 6자리
    bgname char(4) ,                # 분류명       최대   4자리
    bprice int not null ,            # 가격       정수
    bamount smallint not null ,         # 구매수량   정수
    constraint primary key(bnum) ,               # 제약조건
    constraint foreign key ( mid ) references member(mid) # 제약조건
);

# 샘플데이터
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');
INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

# 샘플 확인
select *from member;
select *from buy;

# [1] as 별칭 , 조회 결과의 속성명 변경(딴 원본의 속성명과 상관없다), 복잡한 조회에서 속성명 단순화
select mid from member;
select mid as 회원아이디 from member;
select mid as 회원아이디 , mname 회원명 from member; 	-- as는 생략하고 띄어쓰기로 구분
select mid 회원아이디 from member as m; 	-- member 테이블명을 'm' 으로 별칭 하다.
select mid 회원아이디 from member m;	 	-- as는 생략 가능하다. ( 띄어쓰기 로 구분 )

# [2] distinct 속성명 , 속성값이 중복 인 레코드 제거
select maddr as 주소 from member;			-- 조회 결과 속성 값들의 중복이 존재
select distinct maddr as 주소 from member;	-- 중복이 제거

# [3] 산술연산자 , +더하기  -빼기 , *곱하기 , /나누기 , div 몫 , mod 나머지
select mnumber as 인원수 , mnumber + 3 as 더하기 , mnumber -3 as 빼기 , mnumber * 3 as 곱하기 ,
		mnumber /3 as 나누기 , mnumber div 3 as 몫 , mnumber mod 3 as 나머지
from member;

# [4]
# 비교연산자 : > 초과 < 미만 >=이상 <=이하 = 같다 !=같지않다.
select * from member where mname = '블랙핑크';		-- member테이블의 mname속성의 값이 '블랙핑크' 와 같으면 
select * from member where mnumber = 4; 		-- member테이블의 mnumber속성의 값이 4 이면
select * from member where mname != '블랙핑크';	-- member테이블의 mname속성의 값이 '블랙핑크' 가 아니면
select * from member where not mname = '블랙핑크'; -- member테이블의 mname속성의 값이 '블랙핑크' 와 같지 않으면 
select * from member where mheight <= 162; 		-- member테이블의 mheight속성의 값이 162 이하인
select * from member where mheight >= 165 and mheight <170;		-- mheight속성의 값이 165이상 이면서 170이하
select * from member where mheight between 160 and 170;			-- mheight속성의 값이 165이상 이면서 170이하
select * from member where maddr = '경기' or maddr = '경남' or maddr = '강남'; -- 조건1 or 조건2 or 조건3
select * from member where maddr in('경기' , '강남' , '경남'); 					-- 조건1 or 조건2 or 조건3
# 논리연산자 : not 부정 , and 이면서 , or 이거나 
# 기타연산자 : 속성명 between 시작값 and 끝값 , 속성명 in( 값1 , 값2 , 값3 );
select * from member where mphone1 = '';		-- 속성값이 비어있는 표현 , ' ' 빈칸 대신에 null 사용한다.
select * from member where mphone1 = null;		-- 속성값이 null이면 x불가능
select * from member where mphone1 is null;		-- 속성값이 null이면 o가능
select * from member where mphone1 is not null; -- 속상값이 null 이 아니면
# null 연산자 : 속성명 is null , 속성명 is not null;
select * from member where mname like '에이%';	-- 속성값이 '에이'로 시작하는 			, 에이x 에이xx 에이xxx 에이xxxx
select * from member where mname like '에이_'; 	-- 속성의 값이 '에이'로 시작하는 세글자	, 에이x
select * from member where mname like '%핑크'; 	-- 속성의 값이 '핑크'로 끝나는 , x핑크 xx핑크 xxx핑크 xxxx핑크
select * from member where mname like '%이%';	-- 속성의 값이 '이' 가 포함된
select * from member where mname like '_이_';	-- 속성의 값이 두번째 글짜가 '이' 인 세글자
# 문자패턴 : 속성명 like '문자패턴' , %:문자대응(문자개수상관x) , _:문자대응(_수만큼)

# [5] order by 속성명 asc(오름차순/기본값)/desc(내림차순) , 정렬
# 오름차순 : 1 2 3 4 , a b c , ㄱ ㄴ ㄷ , 25-07-15 25-07-16 25-07-17
# 내림차순 : 4 3 2 1 , c b a , ㄷ ㄴ ㄱ , 25-07-17 25-07-16 25-07-15 
select * from member order by mdebut asc;
select * from member order by mdebut; 	-- asc/desc 생략시 자동으로 asc(기본)
select * from member order by mdebut desc;
# 주의할점 : 2개 이상의 정렬은 ,(쉼표)구분 하되 , 1차정렬에서 중복값이 있을경우 중복값 끼리 2차 정렬
# (1차) 먼저 주소(maddr) 내림차순으로 정렬후 (2차) 주소가 동일한 데이터끼리 mdebut(날짜) 오름차순 정렬
select * from member order by maddr desc , mdebut asc;

# [6] limit 레코드수 , 조회결과 제한 , *페이징처리
select * from member limit 2; 		-- 조회 결과에서 상위2개만 제한
select * from member limit 0 , 2 ; 	-- 조회 결과에서 0번 레코드 부터 2개 제한
select * from member limit 2 , 3 ;	-- 2번 레코드 부터 3개 제한
select * from member order by mheight desc limit 3; -- mheight 속성을 내림차순 으로 정렬 후 상위 3개

DROP DATABASE IF EXISTS exam3;
CREATE DATABASE exam3;
USE exam3;

-- 1. 도서 테이블
CREATE TABLE books (
    book_id      INT NOT NULL,                   -- 도서번호
    title        VARCHAR(50) NOT NULL,           -- 제목
    author       VARCHAR(20) NOT NULL,           -- 저자
    genre        VARCHAR(10) NOT NULL,           -- 장르
    price        INT NOT NULL,                   -- 가격
    stock        INT,                            -- 재고
    pub_date     DATE,                           -- 출판일
    CONSTRAINT PRIMARY KEY (book_id)           -- 기본키 제약조건
);

-- 2. 주문 테이블
CREATE TABLE orders (
    order_id     INT AUTO_INCREMENT,             -- 주문번호
    book_id      INT NOT NULL,                   -- 도서번호 (FK)
    customer     VARCHAR(20) NOT NULL,           -- 고객명
    order_qty    INT NOT NULL,                   -- 주문수량
    order_date   DATE,                           -- 주문일
    CONSTRAINT PRIMARY KEY (order_id),         -- 기본키 제약조건
    CONSTRAINT FOREIGN KEY (book_id) REFERENCES books(book_id) -- 외래키 제약조건
);

-- 샘플 데이터 삽입
INSERT INTO books VALUES(1001, '혼공 SQL', '우재남', '컴퓨터', 22000, 15, '2020-01-01');
INSERT INTO books VALUES(1002, '이것이 자바다', '신용권', '컴퓨터', 30000, 30, '2018-05-20');
INSERT INTO books VALUES(1003, '불편한 편의점', '김호연', '소설', 14000, 5, '2021-04-20');
INSERT INTO books VALUES(1004, '달러구트 꿈 백화점', '이미예', '소설', 13800, 25, '2020-07-08');
INSERT INTO books VALUES(1005, '트렌드 코리아 2023', '김난도', '경제', 19000, 50, '2022-10-05');
INSERT INTO books VALUES(1006, '원씽(The One Thing)', '게리 켈러', '자기계발', 14000, 12, '2013-08-20');
INSERT INTO books VALUES(1007, '역사의 쓸모', '최태성', '역사', 16000, 0, '2018-11-26');
INSERT INTO books VALUES(1008, '파친코', '이민진', '소설', 15800, 3, '2022-07-14');
INSERT INTO books VALUES(1009, 'Do it! 점프 투 파이썬', '박응용', '컴퓨터', 18800, NULL, '2019-06-20');
INSERT INTO books VALUES(1010, '코스모스', '칼 세이건', '과학', 19500, 8, '2006-12-20');
INSERT INTO books VALUES(1011, '혼공 JAVA', '우재남', '컴퓨터', 24000, 17, '2019-01-01');

INSERT INTO orders VALUES(NULL, 1001, '김민준', 2, '2023-01-15');
INSERT INTO orders VALUES(NULL, 1002, '이서연', 1, '2023-01-18');
INSERT INTO orders VALUES(NULL, 1003, '박지훈', 1, '2023-02-01');
INSERT INTO orders VALUES(NULL, 1004, '김민준', 3, '2023-02-05');
INSERT INTO orders VALUES(NULL, 1005, '최수아', 1, '2023-02-11');
INSERT INTO orders VALUES(NULL, 1001, '박지훈', 1, '2023-02-12');
INSERT INTO orders VALUES(NULL, 1008, '이서연', 2, '2023-03-02');
INSERT INTO orders VALUES(NULL, 1009, '정현우', 5, '2023-03-05');
INSERT INTO orders VALUES(NULL, 1002, '김민준', 2, '2023-03-10');
INSERT INTO orders VALUES(NULL, 1006, '최수아', 1, '2023-04-01');
INSERT INTO orders VALUES(NULL, 1003, '박지훈', 3, '2023-04-02');
INSERT INTO orders VALUES(NULL, 1001, '이서연', 1, '2023-04-08');
INSERT INTO orders VALUES(NULL, 1005, '김민준', 2, '2023-04-15');
INSERT INTO orders VALUES(NULL, 1004, '정현우', 1, '2023-04-20');
INSERT INTO orders VALUES(NULL, 1008, '최수아', 1, '2023-05-01');
INSERT INTO orders VALUES(NULL, 1010, '박지훈', 2, '2023-05-05');
INSERT INTO orders VALUES(NULL, 1002, '최수아', 1, '2023-05-12');
INSERT INTO orders VALUES(NULL, 1006, '이서연', 2, '2023-05-20');
INSERT INTO orders VALUES(NULL, 1009, '김민준', 1, '2023-06-01');
INSERT INTO orders VALUES(NULL, 1001, '정현우', 3, '2023-06-07');
INSERT INTO orders VALUES(NULL, 1003, '이서연', 2, '2023-06-15');
INSERT INTO orders VALUES(NULL, 1005, '박지훈', 1, '2023-07-01');
INSERT INTO orders VALUES(NULL, 1010, '김민준', 1, '2023-07-03');
INSERT INTO orders VALUES(NULL, 1004, '최수아', 2, '2023-07-10');
-- =======================================================================


-- [문제 1] books 테이블에서 가격(price)이 20000원 이상인 도서의 title과 price를 조회하세요.
select title, price from books where price>=20000; 
-- [문제 2] books 테이블에서 장르(genre)가 '소설'이 아닌 도서의 모든 정보를 조회하세요.
select * from books;
select * from books where not genre='소설';
-- [문제 3] books 테이블에서 가격(price)이 15000원 이상이고, 재고(stock)가 10권 이상인 도서의 title, price, stock을 조회하세요.
select title, price , stock from books where price>=15000 and stock>=10;
-- [문제 4] books 테이블에서 장르가 '컴퓨터' 이거나 '경제'인 도서의 title과 genre를 조회하세요. (IN 연산자 사용)
select title , genre from books where genre='컴퓨터' or genre= '경제';
select title , genre from books where genre in('컴퓨터' , '경제');
-- [문제 5] books 테이블에서 재고(stock) 정보가 없는(NULL) 도서의 title을 조회하세요.
select title from books where stock is null;
-- [문제 6] books 테이블에서 도서명(title)에 '코리아' 라는 단어가 포함된 도서를 조회하세요. (LIKE 사용)
select * from books where title like '%코리아%';
-- [문제 7] books 테이블에서 저자명(author)이 '김'으로 시작하는 3글자인 도서의 title과 author를 조회하세요. (LIKE 사용)
select title , author from books where author like '김__';
-- [문제 8] books 테이블의 모든 도서 정보를 가격(price)이 비싼 순(내림차순)으로 정렬하여 조회하세요.
select * from books order by price desc;
-- [문제 9] books 테이블의 모든 도서 정보를 출판일(pub_date)이 오래된 순(오름차순)으로 정렬하되, 출판일이 같다면 제목(title)의 가나다순(오름차순)으로 정렬하세요.
select * from books order by pub_date asc, title asc;
-- [문제 10] books 테이블에서 가격이 가장 저렴한 도서 3개의 title과 price를 조회하세요.
select title, price from books order by price asc limit 3;
-- [문제 11] books 테이블에서 가격(price)이 14000원에서 18000원 사이인 도서의 title과 price를 조회하세요. (BETWEEN 연산자 사용)
select title, price from books where price between 14000 and 18000;
-- [문제 12] books 테이블에서 도서명(title)에 '자' 라는 글자가 포함된 도서의 title과 author를 조회하세요.
select title , author from books where title like '%자%';
-- [문제 13] books 테이블에서 장르(genre)가 '소설'과 '역사'가 아닌 도서들의 모든 정보를 조회하세요. (NOT IN 사용)
select * from books where genre not in ( '소설' , '역사' ); 
-- [문제 14] books 테이블에서 장르가 '컴퓨터'이고 가격이 20000원 미만이며, 재고가 20권 이상인 도서의 title을 조회하세요.
select title from books where genre= '컴퓨터' and price<20000;
-- [문제 15] books 테이블의 모든 도서 정보를 장르(genre)의 가나다순(오름차순)으로 정렬하되, 같은 장르 내에서는 가격(price)이 비싼 순(내림차순)으로 정렬하세요.
select * from books order by genre asc, price desc;
-- [문제 16] books 테이블에서 저자명(author)이 '이'씨가 아닌 도서의 title과 author를 조회하세요.
select title , author from books where author not like ( '이%');
-- [문제 17] books 테이블에서 재고(stock) 정보가 있는(NULL이 아닌) 도서의 title과 stock을 조회하세요.
select title , stock from books where stock is not null;
-- [문제 18] books 테이블에서 출판일(pub_date)이 가장 최신인 도서부터 4번째에서 6번째까지의 도서 3개의 title과 pub_date를 조회하세요. (LIMIT 오프셋 사용)
select title , pub_date from books order by pub_date desc limit 4, 3;
-- [문제 19] books 테이블에서 저자가 '김호연'이거나 장르가 '과학'인 도서의 모든 정보를 조회하세요.
select * from books where author = '김호연' or genre='과학';
-- [문제 20] books 테이블에서 도서명(title)이 '점'으로 끝나는 도서의 title과 genre를 조회하세요.
select title , genre from books where title like '%점';

