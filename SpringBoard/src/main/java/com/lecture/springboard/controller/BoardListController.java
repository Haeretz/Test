package com.lecture.springboard.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lecture.springboard.model.Board;
import com.lecture.springboard.service.BoardService;

@Controller
@RequestMapping("/board/list")
public class BoardListController {

	@Autowired
	private BoardService service;

	private static final Logger logger = LoggerFactory.getLogger(BoardListController.class);

	@RequestMapping
	public String view(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
		logger.info("/board/list 요청[page=" + page + "]");

		int total = service.getBoardCount();
		int totalPage = (int) Math.ceil(total / 10.);
		int offset = (page - 1) * 10;
		List<Board> list = service.getBoardList(offset);
		model.addAttribute("total", total);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("list", list);
		return "board/board_list";
	}
}
