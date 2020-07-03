package com.qa.test;

public class IQ1 {

	public static void main(String args[]) {
		String text ="abcdefghijklmnopqrstuvwxyz";
		String reversed="";
		char[] ary= text.toCharArray();
		for(int i= ary.length-1;i>=0;i--) {
			reversed+= ary[i];
		}
	System.out.println(reversed);
	
	
	StringBuffer txt= new StringBuffer(text);
	System.out.println(txt.reverse());
	
	
	
	
	}
	
	
	
	
	
}
