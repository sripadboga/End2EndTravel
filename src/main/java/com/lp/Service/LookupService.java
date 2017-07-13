package com.lp.Service;

import com.lp.Dto.LookupDataDto;
import com.lp.Exception.End2EndAppException;

public interface  LookupService {
	
	public LookupDataDto getLookupDataById(Long lookupDataId) throws End2EndAppException;

}
