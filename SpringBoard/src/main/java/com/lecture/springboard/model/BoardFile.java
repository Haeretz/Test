package com.lecture.springboard.model;

import java.io.Serializable;
import java.util.Date;

public class BoardFile implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int num;
	private int boardNum;
	private String name;
	private String path;
	private Date regDate;

	public BoardFile() {

	}

	public BoardFile(int num, int boardNum, String name, String path, Date regDate) {
		super();
		this.num = num;
		this.boardNum = boardNum;
		this.name = name;
		this.path = path;
		this.regDate = regDate;
	}

	public int getNum() {
		return num;
	}

	public BoardFile setNum(int num) {
		this.num = num;
		return this;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public BoardFile setBoardNum(int boardNum) {
		this.boardNum = boardNum;
		return this;
	}

	public String getName() {
		return name;
	}

	public BoardFile setName(String name) {
		this.name = name;
		return this;
	}

	public String getPath() {
		return path;
	}

	public BoardFile setPath(String path) {
		this.path = path;
		return this;
	}

	public Date getRegDate() {
		return regDate;
	}

	public BoardFile setRegDate(Date regDate) {
		this.regDate = regDate;
		return this;
	}

	@Override
	public String toString() {
		return "BoardFile [num=" + num + ", boardNum=" + boardNum + ", name=" + name + ", path=" + path
				+ ", regDate=" + regDate + "]";
	}
	
}
