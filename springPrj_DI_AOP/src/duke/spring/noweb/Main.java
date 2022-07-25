package duke.spring.noweb;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
		//1. 클래스 정의
		//3. 객체생성, 4. 생성자 호출
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		//2. 객체참조변수 선언, 5. 주소할당
		WriteArticleService articleService = (WriteArticleService)beanFactory.getBean("writeArticleService");
		// 6. 객체 사용
		articleService.write(new Article());
	}
}
