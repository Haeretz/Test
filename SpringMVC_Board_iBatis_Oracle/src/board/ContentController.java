package board;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import service.BoardService;
import dao.BoardVO;

public class ContentController extends AbstractController {

	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		BoardVO article;
		try {
			article = boardService.getArticle(num);
			return new ModelAndView("content", "result", article);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ModelAndView("error", "exception", e.getMessage());
		}
	}
}
