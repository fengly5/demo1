package cn.frode.controller.mapper;

import cn.frode.controller.bean.User;

public interface UserMapper {
	/**
	 * 增加新用户信息
	 * @param user
	 */
	void insertUser(User user);
	/**
	 * 通过id删除用户
	 * @param id
	 * @return
	 */
	Integer deleteUserById(User user);
	/**
	 *更新用户信息
	 * @param user
	 * @return
	 */
	Integer updateUser(User user);
	/**
	 * 通过用户id来查询用户信息
	 * @param id
	 * @return如果存在，返回对象，否则返回null
	 */
	User getUserByid(Integer id);
	/**
	 * 通过用户userName来查询用户信息
	 * @param email
	 * @return如果存在，返回对象，否则返回null
	 */
	User getUserByUsername(String username);
	/**
	 * 查询用户的总数量
	 */
	Integer getCounALL();
}
