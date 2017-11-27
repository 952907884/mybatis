package cn.smbms.dao.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.entity.Bill;

public interface BillMapper {
	
	/**
	 * 根据商品名称查找订单
	 * @param bill
	 * @return
	 */
	List<Bill> findBillByProductName(Bill bill);
	
	/**
	 * 根据供应商id查询订单
	 * @param providerId
	 * @return
	 */
	List<Bill> findBillByProviderId(Integer providerId);
	
	
	List<Bill> findBillAndProviderName(@Param("productName") String productName,@Param("id") Integer id,@Param("isPayment") Integer isPayment);
}
