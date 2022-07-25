package com.message.render;

import com.mesage.provider.IMessageProvider;

public class MessageRederrer {
	
	private IMessageProvider hiProvider;
	private IMessageProvider helloProvider;
	
	public void printMessage() {
		System.out.println(hiProvider.getMessage());
		System.out.println(helloProvider.getMessage());
	}

	public IMessageProvider getHiProvider() {
		return hiProvider;
	}

	public void setHiProvider(IMessageProvider hiProvider) {
		this.hiProvider = hiProvider;
	}

	public IMessageProvider getHelloProvider() {
		return helloProvider;
	}

	public void setHelloProvider(IMessageProvider helloProvider) {
		this.helloProvider = helloProvider;
	}
	
}
