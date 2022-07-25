package com.lecture.springboard.repository;

import java.util.HashMap;
import java.util.List;

import com.lecture.springboard.model.Board;

public interface BoardRepository {

	Board selectOne(int num);

	List<Board> selectList(int offset);
	
	int selectCount();

	int insert(Board board);
	
	int updateReRef(int num);

	int insertReply(Board board);

	int updateReSeq(HashMap<String, Integer> map);

	int updateReadCount(int num);

	int update(Board board);

	int delete(Board board);

}
