package service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import dao.BoardDAO;
import dao.BoardVO;
import dao.PageVO;

interface IBoardService {
	public void setBoardDAO(BoardDAO boardDAO);
	public void insertArticle(BoardVO article) throws Exception;
	public int getArticleCount() throws Exception;
	public BoardVO updateGetArticle(int num) throws Exception;
	public int updateArticle(BoardVO vo) throws Exception;
	public int deleteArticle(int num, String passwd) throws Exception;
	public BoardVO getArticle(int num) throws Exception;
	public List getList(PageVO page_vo) throws Exception;
}
