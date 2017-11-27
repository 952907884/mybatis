package cn.smbms.dao.bill;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.smbms.entity.Bill;
import cn.smbms.utils.MyBatisUtil;

public class BillTest {
	Logger logger=Logger.getLogger(BillTest.class);

	@Test
	public void test1() {
		SqlSession sqlSession=MyBatisUtil.createSqlSession();
		Bill bill = new Bill();
		bill.setProductName("橄榄油");
		List<Bill> list=sqlSession.getMapper(BillMapper.class).findBillByProductName(bill);
		if(list!=null){
			for (Bill b : list) {
				logger.debug("订单编号:"+b.getBillCode()+"\t商品名称:"+b.getProductName()+"\t供应商名称:"+b.getProviderName()+"\t账单金额:"+b.getTotalPrice()+"\t是否付款:"+b.getIsPayment()+"\t创建时间:"+b.getCreationDate());
			}
		}
	}

	@Test
	public void test2() {
		SqlSession sqlSession=MyBatisUtil.createSqlSession();
		List<Bill> list=sqlSession.getMapper(BillMapper.class).findBillByProviderId(2);
		if(list!=null){
			for (Bill b : list) {
				logger.debug("订单编号:"+b.getBillCode()+"\t商品名称:"+b.getProductName()+"\t供应商名称:"+b.getProviderName()+"\t账单金额:"+b.getTotalPrice()+"\t是否付款:"+b.getIsPayment()+"\t创建时间:"+b.getCreationDate());
			}
		}
	}

	@Test
	public void test3(){
		SqlSession sqlSession=MyBatisUtil.createSqlSession();
		List<Bill> list=sqlSession.getMapper(BillMapper.class).findBillAndProviderName("豆",null,null);
		if(list!=null){
			for (Bill b : list) {
				logger.debug("订单编号:"+b.getBillCode()+"\t商品名称:"+b.getProductName()+"\t供应商名称:"+b.getProviderName()+"\t账单金额:"+b.getTotalPrice()+"\t是否付款:"+b.getIsPayment()+"\t创建时间:"+b.getCreationDate());
			}
		}
	}

}
