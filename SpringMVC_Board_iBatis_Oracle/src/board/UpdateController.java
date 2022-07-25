package board;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import service.BoardService;
import dao.BoardVO;

public class UpdateController extends AbstractController {

	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int num = Integer.parseInt(request.getParameter("num"));
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		String passwd = request.getParameter("passwd");
		
		BoardVO vo = new BoardVO(num, writer, subject, email, content, passwd);
		int check;
		try {
			check = boardService.updateArticle(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ModelAndView("error", "exception", e.getMessage());
		}
		if (check!=1){
			return new ModelAndView("error", "exception", "비밀번호가 맞지 않습니다.");
		}
		return new ModelAndView("list", "result", null);
	}
}
