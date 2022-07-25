package com.spring.factory;

import com.mesage.provider.HelloMessageProvider;
import com.mesage.provider.HiMessageProvider;
import com.mesage.provider.IMessageProvider;

public class MessageFactoryBean {

	private String type;
	
	public IMessageProvider getInstance() {
		
		if("Hi".equals(type))
			return HiMessageProvider.getInstance();
		
		else 
			return HelloMessageProvider.getInstance();
	}


	public void setType(String type) {
		this.type = type;
	}
}