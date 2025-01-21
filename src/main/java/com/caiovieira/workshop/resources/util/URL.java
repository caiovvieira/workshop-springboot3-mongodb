package com.caiovieira.workshop.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDateTime;

public class URL {
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} 
		catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static LocalDateTime convertDate(String textDate) {
		LocalDateTime date = LocalDateTime.parse(textDate);
		return date;
	}
}
