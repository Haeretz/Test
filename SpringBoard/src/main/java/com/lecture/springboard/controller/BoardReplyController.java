package com.lecture.springboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lecture.springboard.model.Board;
import com.lecture.springboard.service.BoardService;
import com.lecture.springboard.service.FileUploadService;

@Controller
@RequestMapping("/board/reply")
public class BoardReplyController {

	@Autowired
	BoardService service;

	@Autowired
	FileUploadService uploadService;

	private static final Logger logger = LoggerFactory.getLogger(BoardReplyController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String form(@RequestParam("num") int num, Model model) {
		logger.info("/board/reply 요청num=" + num);
		Board board = service.getBoard(num);
		model.addAttribute("board", board);

		return "board/board_reply";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Board board, MultipartHttpServletRequest request) {
		service.updateReSeq(board.getReRef(), board.getReSeq());
		board.setReLevel(board.getReLevel() + 1);
		board.setReSeq(board.getReSeq() + 1);
		logger.info("reply 삽입" + board);
		service.insertReply(board);
		uploadService.upload(board.getNum(), request);

		return "redirect:/board/list";
	}

}
