package board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import service.BoardService;
import dao.BoardVO;
import dao.PageVO;

public class GetListController extends AbstractController {

	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int pageNum = 1;
		if (request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		List<BoardVO> articleList = null;
		int count = boardService.getArticleCount();
		PageVO page_vo = new PageVO(pageNum, count);
		try {
			if (count != 0) {
				articleList = boardService.getList(page_vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return new ModelAndView("error", "exception", e.getMessage());
		}
		request.setAttribute("page", page_vo);
		return new ModelAndView("list", "result", articleList);
	}
}
