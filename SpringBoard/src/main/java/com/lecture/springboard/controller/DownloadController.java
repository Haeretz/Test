package com.lecture.springboard.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lecture.springboard.model.BoardFile;
import com.lecture.springboard.service.BoardFileService;

@Controller
public class DownloadController {

	@Autowired
	BoardFileService service;

	void setDownload(int num, Model model, String mode) {
		BoardFile boardFile = service.getBoardFile(num);
		
		model.addAttribute("downloadFile", new File("c:/temp/upload/" + boardFile.getPath()));
		model.addAttribute("name", boardFile.getName());
		model.addAttribute("mode", mode);
	}
	
	@RequestMapping("/file/get")
	public String getFile(@RequestParam("num") int num, Model model) {
		this.setDownload(num, model, "get");
		return "download";
	}
	
	@RequestMapping("/file/view")
	public String viewFile(@RequestParam("num") int num, Model model) {
		this.setDownload(num, model, "view");
		return "download";
	}
}
