create database board_db default character set UTF8;
show databases;

create user 'lhe'@'localhost' identified by '1234';

grant all privileges on board_db.* to 'lhe'@'localhost';
flush privileges;

show grants for 'lhe'@'localhost';

use board_db;

-- board_table 생성
create table board_table
(
	postId bigint primary key auto_increment,
    userId bigint,
    constraint fk_id foreign key(userId) 
		references member_table(id) on delete cascade,
    title varchar(100),
    content varchar(500),
    createdAt datetime default now(),
    viewCnt int default 0,
    likes int default 0
);
-- board_file_table 생성
create table board_file_table
(
	id bigint auto_increment primary key,
    originalFileName varchar(100),
    storedFileName varchar(100),
    boardId bigint,
    constraint fk_board_file foreign key(boardId) 
		references board_table(postId) on delete cascade
);
-- member_table 생성
create table member_table
(
	id bigint primary key,
    pw varchar(100)
);

show variables like 'datadir';

select * from board_table;
