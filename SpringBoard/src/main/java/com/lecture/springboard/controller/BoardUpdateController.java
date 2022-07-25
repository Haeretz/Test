package com.lecture.springboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lecture.springboard.model.Board;
import com.lecture.springboard.service.BoardService;

@Controller
@RequestMapping("/board/update")
public class BoardUpdateController {

	@Autowired
	BoardService service;

	@RequestMapping(method = RequestMethod.GET)
	public String form(@RequestParam("num") int num, Model model) {
		Board board = service.getBoard(num);
		model.addAttribute("board", board);
		return "board/board_update";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Board board, Model model) {
		int result = service.update(board);
		if (result == 0) {
			model.addAttribute("Board", board);
			return "board/board_update";
		}

		return "redirect:/board/list";
	}
}
