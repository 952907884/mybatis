package cn.smbms.dao.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.smbms.entity.User;

public interface UserMapper {
	
	/**
	 * 查询所有的用户信息
	 * @return
	 */
	public List<User> findAllUser();
	
	/**
	 * 根据用户名模糊查询
	 * @return
	 */
	List<User> findUserByUserName(String userName);
	
	/**
	 * 根据用户名和角色模糊查询
	 * @param user
	 * @return
	 */
	List<User> findUser(User user);
	
	/**
	 * 使用参为map集合查询
	 * @param map
	 * @return
	 */
	List<User> findUserByMap(Map<String,String> map);
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	List<User> findUserByRole(User user);
	
	void updatePwd(@Param("id") Integer id,@Param("userPassword") String pwd);
	
	/**
	 * 根据角色id查找用户信息
	 * @param roleId
	 * @return
	 */
	public List<User> getUserListByRoleId(@Param("userRole") Integer roleId);
	
	/**
	 * 根据用户id，查找用户信息
	 * @param userId
	 * @return
	 */
	public List<User> getAddressListByUserId(Integer userId);
	
	
	public List<User> getUserList(@Param("userName") String userName,@Param("userRole") Integer userRole);
	
	
	public List<User> getUserByName(@Param("userName") String userName,@Param("userRole") Integer userRole);

}
