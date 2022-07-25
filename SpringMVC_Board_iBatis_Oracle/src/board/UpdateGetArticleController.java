package board;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import service.BoardService;
import dao.BoardVO;

public class UpdateGetArticleController extends AbstractController {

	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int num = Integer.parseInt(request.getParameter("num"));
    	BoardVO vo;
		try {
			vo = boardService.updateGetArticle(num);
			request.setAttribute("result", vo);
    		
			return new ModelAndView("updateForm", "result", vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ModelAndView("error", "exception", e.getMessage());
		}
	}
}
