package com.lecture.springboard.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lecture.springboard.model.Board;
import com.lecture.springboard.model.BoardFile;
import com.lecture.springboard.service.BoardFileService;
import com.lecture.springboard.service.BoardService;

@Controller
@RequestMapping("/board/view")
public class BoardViewController {

	@Autowired
	BoardService service;

	@Autowired
	BoardFileService fileService;

	private static final Logger logger = LoggerFactory.getLogger(BoardViewController.class);

	@ModelAttribute("fileList")
	public List<BoardFile> getFileList(@RequestParam("num") int num) {
		logger.info("파일 리스트 요청[" + num + "]");
		return fileService.getBoardFileList(num);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String view(@RequestParam("num") int num, Model model) {
		service.updateReadCount(num);
		Board board = service.getBoard(num);
		model.addAttribute("board", board);

		return "board/board_view";
	}

}
