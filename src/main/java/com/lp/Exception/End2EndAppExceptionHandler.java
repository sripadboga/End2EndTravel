package com.lp.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lp.Dto.BaseResponseDto;
import com.lp.Util.End2EndAppResponseUtil;

@ControllerAdvice
public class End2EndAppExceptionHandler {

		@ExceptionHandler({Exception.class,End2EndAppException.class})
		@ResponseBody
	    public String handleException(End2EndAppException lpAppException){
			BaseResponseDto baseResponseDto=new BaseResponseDto("failure","Unsuccessful Request",lpAppException);
			return End2EndAppResponseUtil.toResponseJson(baseResponseDto);  	
	    }	

	
}
