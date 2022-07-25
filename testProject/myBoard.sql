DROP table myBoard;
create table myBoard (
	bno number not null,
	title varchar2(30) not null,
	content varchar2(2000) not null,
	writer varchar2(30) not null,
	regDate date default sysdate,
	viewCnt number default 0,
	primary key(bno)
);

DROP sequence myBoard_seq;
create sequence myBoard_seq;

-- insert into myBoard(bno, title, content, writer) values(myBoard_seq.nextval, '글 제목')

-- select bno, title, content, writer, regDate, viewCnt from myBoard where bno = 1;
