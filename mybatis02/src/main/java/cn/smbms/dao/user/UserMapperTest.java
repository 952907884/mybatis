package cn.smbms.dao.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.smbms.entity.Address;
import cn.smbms.entity.User;
import cn.smbms.utils.MyBatisUtil;

public class UserMapperTest {
	Logger logger=Logger.getLogger(UserMapperTest.class);
	@Test
	public void test() {
		SqlSession sqlSession=MyBatisUtil.createSqlSession();
		sqlSession.getMapper(UserMapper.class).updatePwd(2,"123123");
		sqlSession.commit();
		MyBatisUtil.closeSqlSession(sqlSession);
	}
	
	@Test
	public void test1(){
		SqlSession sqlSession=MyBatisUtil.createSqlSession();
		List<User> list = sqlSession.getMapper(UserMapper.class).getUserListByRoleId(2);
		for (User user : list) {
			logger.debug(user.getRole().getId()+"\t"+user.getRole().getRoleCode()+"\t"+user.getRole().getRoleName());
		}
	}
	
	@Test
	public void test2(){
		SqlSession sqlSession=MyBatisUtil.createSqlSession();
		List<User> list = sqlSession.getMapper(UserMapper.class).getAddressListByUserId(2);
		for (User user : list) {
			List<Address> addList=user.getAddressList();
			for (Address address : addList) {
				logger.debug(address.getId()+"\t"+address.getPostCode()+"\t"+address.getContact()+"\t"+address.getAddressDesc()+"\t"+address.getTel());
			}
		}
	}
	
	@Test
	public void test3(){
		SqlSession sqlSession=MyBatisUtil.createSqlSession();
		List<User> list = sqlSession.getMapper(UserMapper.class).getUserList(null, 1);
		for (User user : list) {
			logger.debug(user);
		}
	}
	
	@Test
	public void test4(){
		SqlSession sqlSession=MyBatisUtil.createSqlSession();
		List<User> list = sqlSession.getMapper(UserMapper.class).getUserByName(null,2);
		for (User user : list) {
			logger.debug(user);
		}
	}

}
