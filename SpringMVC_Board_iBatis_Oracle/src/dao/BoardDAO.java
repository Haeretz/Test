package dao;

import java.util.List;

public class BoardDAO {
	IBoardDAO boardDaoImpl;
   	public void setBoardDaoImpl(IBoardDAO boardDaoImpl) {
   		this.boardDaoImpl = boardDaoImpl;
	}
   	public void insertArticle(BoardVO article) throws Exception {
   		boardDaoImpl.insertArticle(article);
    }
    
	public int getArticleCount() throws Exception {
		return boardDaoImpl.getArticleCount();
    }

	public List getArticles(PageVO page_vo) throws Exception {
		return boardDaoImpl.getArticles(page_vo);
    }
 
    public BoardVO getArticle(int num) throws Exception {
    	return boardDaoImpl.getArticle(num);
    }

    public BoardVO updateGetArticle(int num) throws Exception {
        return boardDaoImpl.updateGetArticle(num);
    }

    public int updateArticle(BoardVO article) throws Exception {
        return boardDaoImpl.updateArticle(article);
    }
    
    public int deleteArticle(int num, String passwd) throws Exception {
        return boardDaoImpl.deleteArticle(num, passwd);
    }
}
