drop database if exists assignment8;
create database assignment8;
use assignment8;

create table waiting(
	wno int auto_increment,
    wphone varchar(15) not null ,
    wcount int not null,
    constraint primary key ( wno )
);

update waiting set wphone = "010-8234-3508", wcount = 5 where wno = 1;

select *from waiting;
# 샘플
insert into waiting( wphone , wcount ) values ("010-8778-4412" , 4) ; 
INSERT INTO waiting(wphone, wcount) VALUES ("010-2345-6789", 2);
INSERT INTO waiting(wphone, wcount) VALUES ("010-1111-2222", 1);
INSERT INTO waiting(wphone, wcount) VALUES ("010-3333-4444", 3);
INSERT INTO waiting(wphone, wcount) VALUES ("010-5555-6666", 5);
INSERT INTO waiting(wphone, wcount) VALUES ("010-7777-8888", 2);
INSERT INTO waiting(wphone, wcount) VALUES ("010-9999-0000", 4);
INSERT INTO waiting(wphone, wcount) VALUES ("010-1234-5678", 3);
INSERT INTO waiting(wphone, wcount) VALUES ("010-8765-4321", 1);
INSERT INTO waiting(wphone, wcount) VALUES ("010-0101-0101", 2);
INSERT INTO waiting(wphone, wcount) VALUES ("010-2020-3030", 3);
INSERT INTO waiting(wphone, wcount) VALUES ("010-4040-5050", 4);
INSERT INTO waiting(wphone, wcount) VALUES ("010-6060-7070", 1);
INSERT INTO waiting(wphone, wcount) VALUES ("010-8080-9090", 2);
INSERT INTO waiting(wphone, wcount) VALUES ("010-1212-3434", 5);
INSERT INTO waiting(wphone, wcount) VALUES ("010-5656-7878", 2);
INSERT INTO waiting(wphone, wcount) VALUES ("010-9090-1212", 3);
INSERT INTO waiting(wphone, wcount) VALUES ("010-3434-5656", 4);
INSERT INTO waiting(wphone, wcount) VALUES ("010-7878-9090", 1);
INSERT INTO waiting(wphone, wcount) VALUES ("010-9998-7776", 2);
