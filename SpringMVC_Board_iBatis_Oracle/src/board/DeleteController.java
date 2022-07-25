package board;

import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import service.BoardService;
import dao.BoardVO;

public class DeleteController extends AbstractController {
	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String passwd = request.getParameter("passwd");
		
		int check;
		try {
			check = boardService.deleteArticle(num, passwd);
			if (check==0) {
    			return new ModelAndView("error", "exception", "��й�ȣ�� ���� �ʽ��ϴ�.");
    		} else if (check==1) {    			
    			return new ModelAndView("list", "result", null);
    		} else {
    			return new ModelAndView("error", "exception", "�ش��ڷᰡ �������� �ʽ��ϴ�.");
    		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ModelAndView("error", "exception", e.getMessage());
		}
	}
}
