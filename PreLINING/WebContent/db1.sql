create table member(
id 	 varchar2(30) primary key,
pwd	 varchar2(40),
name	 varchar2(30),
nickname varchar2(30) unique,
email	 varchar2(50) not null,
phone    varchar2(50) not null,
addr	 varchar2(200) not null,
point    number,
type 	 number
);

select * from member;

create table board(
num		     number primary key,
g_name		 varchar2(30) references member(nickname) on delete cascade,
s_name		 varchar2(30) references shop(name) on delete cascade,
w_date		 date,
content		 varchar2(500) not null,
score        number,
parent		 number
);

insert into board values(seq_board.nextval, 'guest1', 'shop1', sysdate, '4踰덈��뙎湲�', 0, 9);
update board set parent=3 where num=6;

create table shop(
num		 	 number primary key,
id			 references member(id) on delete cascade,
name		 varchar2(30) unique,
menu		 varchar2(200) not null,
location	 varchar2(100) not null,
phone    	 varchar2(50),
img		 	 varchar2(500),
content   	 varchar2(500),
category	 varchar2(200),
queue_num	 number,
viewcount	 number,
scoreavg	 number(2,1)
);

create table shop as select * from shop2
insert into shop2(num,id,name,menu,location,phone,img,content,category,queue_num,viewcount) select num,id,name,menu,location,phone,img,content,category,queue_num,viewcount from shop
update shop2 set scoreavg=3.3 where num=83

create table queue(
num			 number primary key,
s_name		 varchar2(30) references shop(name) on delete cascade,
g_name		 varchar2(30) references member(nickname) on delete cascade,
g_phone		 varchar2(50),
pnum		 number,
snum		 number,
r_date		 date
);

insert into queue values(seq_queue.nextval, '移섑궓媛�寃�', 'kitri', 2, sysdate);

create table log(
num			 number primary key,
s_name		 varchar2(30),
g_name		 varchar2(30),
g_phone		 varchar2(50),
pnum		 number,
snum		 number,
r_date		 date
);

insert into log values(1, 'sname','gname',2,1,sysdate)


create table log2(
num			 number primary key,
s_name		 varchar2(30),
g_name		 varchar2(30), 
pnum		 number,
snum		 number,
r_date		 varchar2(100)
);


create sequence seq_shop;
create sequence seq_log;
create sequence seq_board;
create sequence seq_queue;

select * from member;
select * from shop;
select * from board;
select * from queue;
select * from log;
delete from shop where name='미스터피자';

delete from queue where g_name='guest1';
delete from board where g_name='shop1';
alter table shop modify(scoreavg number(1,1))

drop table member cascade constraints;
drop table shop cascade constraints;
drop table board cascade constraints;
drop table queue cascade constraints;
drop table log cascade constraints;

drop sequence seq_shop;
drop sequence seq_log;
drop sequence seq_board;
drop sequence seq_queue;
