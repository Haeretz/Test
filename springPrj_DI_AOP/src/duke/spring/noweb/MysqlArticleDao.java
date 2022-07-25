package duke.spring.noweb;

public class MysqlArticleDao implements ArticleDao {

	@Override
	public void insert(Article article) {
		System.out.println("MysqlArticleDao.insert() 실행");
	}

}
