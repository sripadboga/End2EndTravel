package com.lp.Dao;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.lp.DaoConfig.GenericDaoImpl;
import com.lp.Entity.LookupDataEntity;

@Repository("lookupDao")
public class LookupDaoImpl extends GenericDaoImpl<LookupDataEntity> implements LookupDao{

	@Override
	public LookupDataEntity getLookupDataById(Long lookupDataId) throws SQLException {

		return findById(lookupDataId);
	}

	
	
	

}
