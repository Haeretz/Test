package board;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import service.BoardService;
import dao.BoardVO;

public class WriteController extends AbstractController {

	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		String passwd = request.getParameter("passwd");
		int num = Integer.parseInt(request.getParameter("num"));
		int ref = Integer.parseInt(request.getParameter("ref"));
		int re_step = Integer.parseInt(request.getParameter("re_step"));
		int re_level = Integer.parseInt(request.getParameter("re_level"));
				
		BoardVO vo = new BoardVO(num, writer, subject, email, content, passwd, ref, re_step, re_level);
		vo.setReg_date(new Timestamp(System.currentTimeMillis()) );
		vo.setIp(request.getRemoteAddr());
		
		try {
			boardService.insertArticle(vo);
			return new ModelAndView("list", "result", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ModelAndView("error", "exception", e.getMessage());
		}
	}
}
