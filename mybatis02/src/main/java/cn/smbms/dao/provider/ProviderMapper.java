package cn.smbms.dao.provider;

import java.util.List;

import cn.smbms.entity.Provider;

public interface ProviderMapper {
	
	/**
	 * 查询供应商的记录数 
	 * @return
	 */
	public int findProviderCount();
	
	public List<Provider> findAllProvider();


}
