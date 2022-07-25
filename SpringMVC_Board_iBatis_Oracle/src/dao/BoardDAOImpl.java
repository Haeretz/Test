package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

public class BoardDAOImpl implements IBoardDAO {
	private SqlMapClient sqlMapClient;

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	public List<BoardVO> getArticles(PageVO page_vo) throws Exception {
		page_vo.setStartRow(page_vo.getStartRow()-1);
		return sqlMapClient.queryForList("getArticles", page_vo);
	}
	public void insertArticle(BoardVO article) throws Exception {
		int num=article.getNum();
		int ref=article.getRef();
		int re_step=article.getRe_step();
		int re_level=article.getRe_level();
		int number=0;
        
		Object ret = sqlMapClient.queryForObject("getMaxBoard");
		
		if (ret == null) {
			number = 1;
		} else {
			number = (Integer)ret + 1;
		}
		if (num!=0) { 
			sqlMapClient.update("updateStepArticle", article);
        	re_step=re_step+1;
    		re_level=re_level+1;
    	}else{
    		ref=number;
    		re_step=0;
    		re_level=0;
    	}
		article.setRef(ref);
		article.setRe_step(re_step);
		article.setRe_level(re_level);
		sqlMapClient.insert("insertArticle", article);
    }
    
	public int getArticleCount() throws Exception {
		return (Integer)sqlMapClient.queryForObject("getArticleCount");
	}
		
	public BoardVO getArticle(int num) throws Exception {
		sqlMapClient.update("updateReadcountArticle", num);
		return (BoardVO)sqlMapClient.queryForObject("getArticle", num);
	}

	public BoardVO updateGetArticle(int num) throws Exception {
		return (BoardVO)sqlMapClient.queryForObject("getArticle", num);
	}
	
	public int updateArticle(BoardVO article) throws Exception {
		int x=-1;
		
		BoardVO temp = (BoardVO)sqlMapClient.queryForObject("getArticle", article.getNum());
		if (temp != null) {
			if(temp.getPasswd().equals(article.getPasswd())){
				sqlMapClient.update("updateArticle", article);
				x= 1;
			}else{
				x= 0;
			}
		}
		return x;
	}
    
	public int deleteArticle(int num, String passwd) throws Exception {
		int x=-1;
        
        BoardVO temp = (BoardVO)sqlMapClient.queryForObject("getArticle", num);
		if (temp != null) {
			if(temp.getPasswd().equals(passwd)){
				sqlMapClient.delete("deleteArticle", num);
				//sqlMapClient.delete("alterTable");
				x= 1;
			}else{
				x= 0;
			}
		}
		return x;
	}
}
