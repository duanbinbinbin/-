package com.bin.lookz.util;

public class StringUtilBin {

	/**
	 * ÅÐ¶Ï×Ö·û´®ÊÇ·ñÎª¿Õ ÊÇµÄ·µ»Øtrue ·ñ·µ»Øfalse
	 * */
	public static boolean validateNull(String args){
		if(args == null||args.length()==0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * ¹ýÂËhtml×Ö·û
	 * */
	public static String filterHtml(String input){
		if(input == null){
			return null;
		}
		if(input.length()==0){
			return input;
		}
		input = input.replaceAll("&", "&amp;");
		input = input.replaceAll("<", "&lt;");
		input = input.replaceAll(">", "&gt;");
		input = input.replaceAll(" ", "&nbsp;");
		input = input.replaceAll("'", "&&#39;");
		input = input.replaceAll("\"", "&quot");
		return input.replaceAll("\n", "<br>");
	}
	
}
