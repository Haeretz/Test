package com.lecture.springboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lecture.springboard.model.Board;
import com.lecture.springboard.service.BoardService;
import com.lecture.springboard.service.FileUploadService;

@Controller
@RequestMapping("/board/write")
public class BoardWriteController {

	@Autowired
	BoardService service;

	@Autowired
	FileUploadService uploadService;

	private static final Logger logger = LoggerFactory.getLogger(BoardWriteController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		logger.info("/board/write 요청");
		return "board/board_write";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Board board, MultipartHttpServletRequest request) {
		logger.info("board 추가" + board);
		service.insert(board);
		logger.info("file 추가[" + board.getNum() + "]");
		uploadService.upload(board.getNum(), request);

		return "redirect:/board/list";
	}
}
