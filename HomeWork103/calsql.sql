create table cal (
	cal_id int not null auto_increment,
	op1 varchar(200) not null,
	op varchar(200) not null,
	op2 varchar(200) not null,
	result int,	
	primary key (cal_id)
);

select * from cal;