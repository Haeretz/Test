package duke.spring.noweb;

public class WriteArticleServiceImpl implements WriteArticleService {

	private ArticleDao articleDao; 

	public WriteArticleServiceImpl(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public void write(Article article) {
		System.out.println("WriteArticleServiceImpl.write() 메소드실행");
		articleDao.insert(article);
	}

}
