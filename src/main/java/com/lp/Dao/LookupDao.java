package com.lp.Dao;

import java.sql.SQLException;

import com.lp.DaoConfig.CurdsDaoInterface;
import com.lp.Entity.LookupDataEntity;

public interface LookupDao extends CurdsDaoInterface<LookupDataEntity> {

	public LookupDataEntity getLookupDataById(Long lookupDataId) throws SQLException;

}
