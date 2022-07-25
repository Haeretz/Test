package com.lecture.springboard.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lecture.springboard.model.Board;
import com.lecture.springboard.repository.BoardRepository;

@Service
@Transactional
public class BoardService {
	
	@Autowired
	private BoardRepository repository;

	public Board getBoard(int num) {
		return repository.selectOne(num);
	}

	public List<Board> getBoardList(int offset) {
		return repository.selectList(offset);
	}
	
	public int getBoardCount() {
		return repository.selectCount();
	}

	public int insert(Board board) {
		int result = repository.insert(board);
		if(result > 0) {
			board.setReRef(board.getNum());
			repository.updateReRef(board.getNum());
		}
		return board.getNum();
	}

	public int insertReply(Board board) {
		return repository.insertReply(board);
	}

	public int updateReSeq(int reRef, int reSeq) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("reRef", reRef);
		map.put("reSeq", reSeq);
		return repository.updateReSeq(map);
	}
	
	public int updateReadCount(int num) {
		return repository.updateReadCount(num);
	}
	
	public int update(Board board) {
		return repository.update(board);
	}
	
	public int delete(Board board) {
		return repository.delete(board);
	}

}
