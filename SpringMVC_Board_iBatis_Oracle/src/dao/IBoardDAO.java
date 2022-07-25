package dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

interface IBoardDAO  {
	public void insertArticle(BoardVO article) throws Exception;
    public int getArticleCount() throws Exception;
	public List getArticles(PageVO page_vo) throws Exception;
	public BoardVO getArticle(int num) throws Exception;
    public BoardVO updateGetArticle(int num) throws Exception;
    public int updateArticle(BoardVO article) throws Exception;
    public int deleteArticle(int num, String passwd) throws Exception;
}
