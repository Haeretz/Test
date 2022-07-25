package service;

import java.util.List;

import dao.BoardDAO;
import dao.BoardVO;
import dao.PageVO;

public class BoardService {
	IBoardService boardServiceImpl;
	public void setBoardServiceImpl(IBoardService boardServiceImpl) {
		this.boardServiceImpl = boardServiceImpl;
	}
	public void insertArticle(BoardVO article) throws Exception {
		boardServiceImpl.insertArticle(article);
	}
	public int getArticleCount() throws Exception {
		return boardServiceImpl.getArticleCount();
	}
	public BoardVO updateGetArticle(int num) throws Exception {
		return boardServiceImpl.updateGetArticle(num);
	}
	
	public int updateArticle(BoardVO vo) throws Exception {
		return boardServiceImpl.updateArticle(vo);
	}

	public int deleteArticle(int num, String passwd) throws Exception {
		return boardServiceImpl.deleteArticle(num, passwd);
	}
	public BoardVO getArticle(int num) throws Exception {
		return boardServiceImpl.getArticle(num);
	}
	
	public List getList(PageVO page_vo) throws Exception {
		return boardServiceImpl.getList(page_vo);
	}
}

