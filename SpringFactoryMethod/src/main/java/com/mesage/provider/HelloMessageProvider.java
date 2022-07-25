package com.mesage.provider;

public class HelloMessageProvider implements IMessageProvider{

	private static HelloMessageProvider instance = new HelloMessageProvider();
	
	private HelloMessageProvider(){}
	
	@Override
	public String getMessage() {
		return "Hello World";
	}

	public static IMessageProvider getInstance() {
		return instance;
	}
}
