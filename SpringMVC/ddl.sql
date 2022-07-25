drop table GUESTBOOK_MESSAGE;
create table GUESTBOOK_MESSAGE (
	GUESTBOOK_MESSAGE_ID  int  not  null,
	GUEST_NAME	varchar(20) not null,
	CONTENT	varchar(3000) not null
);

ALTER TABLE GUESTBOOK_MESSAGE
       ADD   PRIMARY KEY (GUESTBOOK_MESSAGE_ID)  ;

drop Sequence seq_log;
Create Sequence seq_log
start with 1
increment by 1
maxvalue 10000000;

/*insert into GUESTBOOK_MESSAGE values(seq_log.nextval,'a','a');
commit;
*/