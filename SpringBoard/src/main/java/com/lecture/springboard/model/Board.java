package com.lecture.springboard.model;

import java.io.Serializable;
import java.util.Date;

public class Board implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int num;
	private String writer;
	private String password;
	private String title;
	private String content;
	private int reRef;
	private int reLevel;
	private int reSeq;
	private int readCount;
	private Date regDate;

	public Board() {

	}

	public Board(int num, String writer, String password, String title, String content, int reRef, int reLevel,
			int reSeq, int readCount, Date regDate) {
		super();
		this.num = num;
		this.writer = writer;
		this.password = password;
		this.title = title;
		this.content = content;
		this.reRef = reRef;
		this.reLevel = reLevel;
		this.reSeq = reSeq;
		this.readCount = readCount;
		this.regDate = regDate;
	}

	public int getNum() {
		return num;
	}

	public Board setNum(int num) {
		this.num = num;
		return this;
	}

	public String getWriter() {
		return writer;
	}

	public Board setWriter(String writer) {
		this.writer = writer;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Board setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Board setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getContent() {
		return content;
	}

	public Board setContent(String content) {
		this.content = content;
		return this;
	}

	public int getReRef() {
		return reRef;
	}

	public Board setReRef(int reRef) {
		this.reRef = reRef;
		return this;
	}

	public int getReLevel() {
		return reLevel;
	}

	public Board setReLevel(int reLevel) {
		this.reLevel = reLevel;
		return this;
	}

	public int getReSeq() {
		return reSeq;
	}

	public Board setReSeq(int reSeq) {
		this.reSeq = reSeq;
		return this;
	}

	public int getReadCount() {
		return readCount;
	}

	public Board setReadCount(int readCount) {
		this.readCount = readCount;
		return this;
	}

	public Date getRegDate() {
		return regDate;
	}

	public Board setRegDate(Date regDate) {
		this.regDate = regDate;
		return this;
	}

	@Override
	public String toString() {
		return "Board [num=" + num + ", writer=" + writer + ", password=" + password + ", title=" + title + ", content="
				+ content + ", reRef=" + reRef + ", reLevel=" + reLevel + ", reSeq=" + reSeq + ", readCount="
				+ readCount + ", regDate=" + regDate + "]";
	}
	
}
