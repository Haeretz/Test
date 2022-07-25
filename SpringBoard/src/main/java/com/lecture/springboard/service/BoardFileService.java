package com.lecture.springboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lecture.springboard.model.BoardFile;
import com.lecture.springboard.repository.BoardFileRepository;

@Service
@Transactional
public class BoardFileService {

	@Autowired
	private BoardFileRepository repository;

	public BoardFile getBoardFile(int num) {
		return repository.selectOne(num);
	}

	public List<BoardFile> getBoardFileList(int boardNum) {
		return repository.selectList(boardNum);
	}

	public int insert(BoardFile boardFile) {
		return repository.insert(boardFile);
	}

	public int update(BoardFile boardFile) {
		return repository.update(boardFile);
	}

	public int delete(int num) {
		return repository.delete(num);
	}

}
