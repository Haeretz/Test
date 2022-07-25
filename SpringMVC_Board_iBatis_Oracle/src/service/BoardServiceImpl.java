package service;

import java.util.List;

import dao.BoardDAO;
import dao.BoardVO;
import dao.PageVO;

public class BoardServiceImpl implements IBoardService {
	BoardDAO boardDAO;
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	public void insertArticle(BoardVO article) throws Exception {
		boardDAO.insertArticle(article);
	}
	public int getArticleCount() throws Exception {
		return boardDAO.getArticleCount();
	}
	public BoardVO updateGetArticle(int num) throws Exception {
		return boardDAO.updateGetArticle(num);
	}
	
	public int updateArticle(BoardVO vo) throws Exception {
		return boardDAO.updateArticle(vo);
	}

	public int deleteArticle(int num, String passwd) throws Exception {
		return boardDAO.deleteArticle(num, passwd);
	}
	public BoardVO getArticle(int num) throws Exception {
		return boardDAO.getArticle(num);
	}
	
	public List getList(PageVO page_vo) throws Exception {
		return boardDAO.getArticles(page_vo);
	}
}
