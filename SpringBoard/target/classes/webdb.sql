DROP TABLE IF EXISTS board;
CREATE TABLE board (
	  num			int			auto_increment
	, writer		varchar(15)
	, password		varchar(15)
	, title			varchar(200)
	, content		longtext
	, re_ref		int			# 글그룹
	, re_level		int			# 글레벨
	, re_seq		int			# 글그룹내에서의순차번호
	, read_count	int			# 조회수
	, reg_date		date
	PRIMARY KEY(num)
);

drop table if exists board_file;
create table board_file(
	  num	int	auto_increment
	, board_num	int
	, name	varchar(256)
	, path	varchar(512)
	, reg_date	datetime
	, primary key (num)
	, foreign key (board_num) references board(num) on delete cascade
);