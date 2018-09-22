package com.gmc.utils;

public class generalutil {
	
	public static int getCharCount(String str) {
		int count = 0;
	    for(int i =0; i < str.length(); i++){
	        if(str.charAt(i) == 'i'){
	            count++;
	            }
	    }
	    return count;
	}

}
