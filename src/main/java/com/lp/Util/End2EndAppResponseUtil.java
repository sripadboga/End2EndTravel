package com.lp.Util;

import com.google.gson.Gson;

public final class End2EndAppResponseUtil {
	
	private End2EndAppResponseUtil(){
		
	}

	public static String toResponseJson(Object obj){
		Gson gson=new Gson();
		return gson.toJson(obj);
	}
	
}
