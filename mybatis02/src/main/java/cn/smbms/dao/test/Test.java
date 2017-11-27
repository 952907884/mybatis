package cn.smbms.dao.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import cn.smbms.dao.user.UserMapper;
import cn.smbms.entity.User;
import cn.smbms.utils.MyBatisUtil;

public class Test {
	
	Logger logger=Logger.getLogger(Test.class);
	
	
	
	
	
	/*@org.junit.Test
	public void test3(){
		SqlSession sqlSession=MyBatisUtil.createSqlSession();
		List<User> list=new ArrayList<User>();
		list=sqlSession.selectList("cn.smbms.dao.user.UserMapper.findAllUser");
		for (User user : list) {
			logger.debug(user.toString());
		}
		MyBatisUtil.closeSqlSession(sqlSession);
	}*/
	
	
	/*@org.junit.Test
	public void test4(){
		SqlSession sqlSession=MyBatisUtil.createSqlSession();
		List<Provider> list=sqlSession.selectList("cn.smbms.dao.provider.ProviderMapper.findAllProvider");
		if(list!=null){
			for (Provider provider : list) {
				logger.debug(provider.toString());
			}
		}
		MyBatisUtil.closeSqlSession(sqlSession);
	
	}
	
	@org.junit.Test
	public void test5(){
		SqlSession sqlSession=MyBatisUtil.createSqlSession();
		List<Provider> list=sqlSession.getMapper(ProviderMapper.class).findAllProvider();
		if(list!=null){
			for (Provider provider : list) {
				logger.debug(provider.toString());
			}
		}
		MyBatisUtil.closeSqlSession(sqlSession);
	}*/
	
	@org.junit.Test
	public void test6(){
		SqlSession sqlSession=MyBatisUtil.createSqlSession();
		List<User> list=sqlSession.getMapper(UserMapper.class).findUserByUserName("赵");
		for (User user : list) {
			logger.debug(user.toString());
		}
		MyBatisUtil.closeSqlSession(sqlSession);
	}
	
	@org.junit.Test
	public void test7(){
		SqlSession sqlSession=MyBatisUtil.createSqlSession();
		User user=new User();
		user.setUserName("赵燕");
		user.setUserRole(3);
		List<User> list=sqlSession.getMapper(UserMapper.class).findUser(user);
		for (User u : list) {
			logger.debug(u.toString());
		}
		MyBatisUtil.closeSqlSession(sqlSession);
	}
	
	@org.junit.Test
	public void test8(){
		SqlSession sqlSession=MyBatisUtil.createSqlSession();
		Map<String,String> map=new HashMap<String,String>();
		map.put("uName", "赵");
		map.put("uRole", "3");
		List<User> list=sqlSession.getMapper(UserMapper.class).findUserByMap(map);
		for (User u : list) {
			logger.debug(u.toString());
		}
		MyBatisUtil.closeSqlSession(sqlSession);
	}
	
	
	@org.junit.Test
	public void test9(){
		SqlSession sqlSession=MyBatisUtil.createSqlSession();
		User user=new User();
		user.setUserName("赵");
		user.setUserRole(3);
		List<User> list=sqlSession.getMapper(UserMapper.class).findUserByRole(user);
		for (User u : list) {
			logger.debug(u);
		}
		MyBatisUtil.closeSqlSession(sqlSession);
	}
	
	
}
