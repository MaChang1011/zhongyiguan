package com.zyt.dao.resource;

import java.util.List;
import java.util.Map;

import com.zyt.base.IBaseMapper;
import com.zyt.bo.resource.CaseBo;
import com.zyt.entity.resource.AddressEntity;

public interface IAddressMapper extends 
		IBaseMapper<AddressEntity> 
{
	public abstract List<CaseBo> findAllBo(Map<String, Object> paramMap);
}
