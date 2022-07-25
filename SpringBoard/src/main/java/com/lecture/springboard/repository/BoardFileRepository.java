package com.lecture.springboard.repository;

import java.util.List;

import com.lecture.springboard.model.BoardFile;

public interface BoardFileRepository {

	BoardFile selectOne(int num);
	
	List<BoardFile> selectList(int boardNum);
	
	int selectCount();
	
	int insert(BoardFile boardFile);
	
	int update(BoardFile boardFile);
	
	int delete(int num);
}
