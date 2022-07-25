package com.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mesage.provider.IMessageProvider;
import com.message.render.MessageRederrer;
import com.spring.factory.MessageFactoryBean;

public class MainApplication {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext();
		appCtx.load("classpath:META-INF/spring/app-context.xml");
		appCtx.registerShutdownHook();
		appCtx.refresh();
		
		MessageRederrer render = (MessageRederrer)appCtx.getBean("messageRenderrer");
		render.printMessage();
		
		appCtx.close();
	}
}
