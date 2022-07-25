package org.ojsag.spring.di.cal.main;

import org.ojsag.spring.di.calcontroller.CalController;
import org.ojsag.spring.di.calentity.CalVO;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalTest {

	public static void main(String[] args) {
		String configLocation = "classpath:applicationContext.xml";
		//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class,Config2.class);
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		CalController cc = ctx.getBean("calController", CalController.class);
		CalVO vo = ctx.getBean("calVO", CalVO.class);		
		vo.setOps("50","sub","11");
		cc.doService(vo);		
		ctx.close();
	}

}
