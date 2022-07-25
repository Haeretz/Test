package com.lecture.springboard.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lecture.springboard.model.BoardFile;

@Service
public class FileUploadService {

	@Autowired
	BoardFileService service;

	public void upload(int boardNum, MultipartHttpServletRequest request) {
		for (MultipartFile part : request.getFiles("file")) {
			if (part.isEmpty()) {
				return;
			}

			String name = part.getOriginalFilename();
			String path = System.currentTimeMillis() + "_" + name;
			BoardFile boardFile = new BoardFile();
			boardFile.setBoardNum(boardNum).setName(name).setPath(path);

			File dest = new File("c:/temp/upload/" + path);

			try {
				part.transferTo(dest);
				service.insert(boardFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
