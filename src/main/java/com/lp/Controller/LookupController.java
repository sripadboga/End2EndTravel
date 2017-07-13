package com.lp.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lp.Dto.BaseResponseDto;
import com.lp.Dto.LookupDataDto;
import com.lp.Exception.End2EndAppException;
import com.lp.Service.LookupService;
import com.lp.Util.End2EndAppResponseUtil;

@RestController
@RestControllerAdvice
public class LookupController {

	static final Logger LOGGER = LoggerFactory.getLogger(LookupController.class);
	
	@Autowired
	private LookupService lookupService;

	@RequestMapping(value = "/lookupData", method = RequestMethod.GET)
	@ResponseBody
	public String getLookupDataById(@RequestParam("id") Long lookupDataId) throws End2EndAppException {
			LOGGER.info("controllercase");
			LookupDataDto lookpdataDto=lookupService.getLookupDataById(lookupDataId);
			return End2EndAppResponseUtil.toResponseJson(new BaseResponseDto("Success", "Processed Succesfully", lookpdataDto));
	}

}
