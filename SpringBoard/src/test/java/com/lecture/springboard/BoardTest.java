package com.lecture.springboard;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lecture.springboard.model.Board;
import com.lecture.springboard.service.BoardService;

public class BoardTest {

	public static void main(String[] args) {
		String[] configLocations = new String[] { 
				  "test-context.xml"
				, "config/spring/database-context.xml"
				, "config/spring/mybatis-context.xml"
		};
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);

		BoardService service = context.getBean("boardService", BoardService.class);

		if (service == null) {
			System.out.println("Service is not ready");
			return;
		}

		System.out.println("Service is ready");
		boardServiceTest(service);
	}

	private static void boardServiceTest(BoardService service) {
		List<Board> list = service.getBoardList(0);
		if (list.size() == 0) {
			for (int i = 1; i <= 10; i++) {
				service.insert(
						new Board().setTitle("제목" + i).setWriter("글쓴이" + i).setPassword(i + "").setContent("내용" + i));
			}
		}

		for (Board board : list) {
			System.out.println(board);
		}
		
		System.out.println(service.getBoard(1));
		
//		for (int i = 1; i <= 10; i++) {
//			service.insertReply(
//					new Board().setTitle("제목" + i).setWriter("글쓴이" + i).setPassword(i + "").setContent("내용" + i));
//		}
		
//		System.out.println(service.updateReSeq(1, 2));
		
//		for (Board board : list) {
//			System.out.println(board);
//		}
		
//		System.out.println(service.updateReadCount(1));
		
//		service.update(new Board().setNum(1).setTitle("수정 제목"));
	}

}
