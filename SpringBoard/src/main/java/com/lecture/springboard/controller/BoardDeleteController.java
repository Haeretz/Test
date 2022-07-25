package com.lecture.springboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lecture.springboard.model.Board;
import com.lecture.springboard.service.BoardService;

@Controller
@RequestMapping("/board/delete")
public class BoardDeleteController {
	@Autowired
	BoardService service;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String delete(Board board) {
		int result = service.delete(board);
		if (result > 0)
			return "OK";
		else
			return "FAIL";
	}

}
