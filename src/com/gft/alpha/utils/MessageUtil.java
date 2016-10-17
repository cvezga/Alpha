package com.gft.alpha.utils;

public class MessageUtil {

	public String getMessage(String message, String delim, int index){
		String[] tkns = message.split(delim);
		if(tkns.length>index){
			return tkns[index];
		}
		return null;
	}
}
