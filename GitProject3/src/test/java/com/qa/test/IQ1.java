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
	
	
	
	//String reverse using String Builder or String Buffer Class
	
	StringBuilder txt= new StringBuilder(text);
	System.out.println(txt.reverse());
	
	
	
	
	}
	
	
	
	
	
}
