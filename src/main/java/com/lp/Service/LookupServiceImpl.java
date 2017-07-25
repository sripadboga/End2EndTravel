package com.lp.Service;

import java.sql.SQLException;
import java.util.List;

import org.dozer.Mapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lp.Dao.LookupDao;
import com.lp.Dto.LookupDataDto;
import com.lp.Dto.LookupItemDataDto;
import com.lp.Entity.LookupDataEntity;
import com.lp.Entity.LookupItemDataEntity;
import com.lp.Exception.End2EndAppException;
import com.lp.Util.End2EndAppResponseUtil;


@Service("lookupService")
@Transactional(rollbackFor=Exception.class)
public class LookupServiceImpl implements LookupService{
	
	@Autowired
    private DozerBeanMapperFactoryBean dozerBean;

	@Autowired
	private LookupDao lookupDao; 
	
	static final Logger LOGGER = LoggerFactory.getLogger(LookupServiceImpl.class);
	
	@Override
	public LookupDataDto getLookupDataById(Long lookupDataId) throws End2EndAppException  {
		LookupDataDto lookpDataDto=new LookupDataDto();
		LookupDataEntity lookupDataEntity = null;
		List<LookupItemDataDto> lookupItemDataDtos=null;
		Mapper map=null;
		try {
			  lookupDataEntity = lookupDao.getLookupDataById(lookupDataId);
              map=dozerBean.getObject();
              List<LookupItemDataEntity> lookupItemDataEntities=lookupDataEntity.getLookupItemData();
              lookupItemDataDtos=End2EndAppResponseUtil.map(map, lookupItemDataEntities, LookupItemDataDto.class);
              map.map(lookupDataEntity,lookpDataDto);
              lookpDataDto.setLookupItemData(lookupItemDataDtos);
		} catch (SQLException e) {
			LOGGER.info("Error Describtion", e);
			throw new End2EndAppException(e);
		} catch (Exception e) {
			LOGGER.info("Error Describtion", e);
			throw new End2EndAppException(e);
		}
		return lookpDataDto;
	}
	

}
