package com.mesage.provider;

public class HiMessageProvider implements IMessageProvider{

	private static HiMessageProvider instance = new HiMessageProvider();
	
	private HiMessageProvider() {}
	
	@Override
	public String getMessage() {
		return "HI world";
	}

	public static IMessageProvider getInstance() {
		return instance;
	}
}
