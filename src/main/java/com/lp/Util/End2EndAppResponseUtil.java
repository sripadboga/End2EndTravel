package com.lp.Util;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;

import com.google.gson.Gson;

public final class End2EndAppResponseUtil {
	
	private End2EndAppResponseUtil(){
		
	}

	public static String toResponseJson(Object obj){
		Gson gson=new Gson();
		return gson.toJson(obj);
	}
	
	public static final <T,U> List<U> map(final Mapper mapper,final List<T> source,final Class<U> destType){
	    final List<U> dest = new ArrayList<>();
	    for (T element : source) {
	        dest.add(mapper.map(element, destType));
	    }
	    return dest;
	}
	
}
