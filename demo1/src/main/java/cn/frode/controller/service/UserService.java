package cn.frode.controller.service;

import cn.frode.controller.bean.User;

public interface UserService {
	/**
	 * 注册新用户
	 * @param user
	 */
	void register(User user);
	/**
	 * 判断用户是否存在
	 * @param user
	 * @return
	 */
	boolean checkUsername(User user);
	/**
	 * 修改用户信息
	 */
	void updateUser(Integer id,String username,Integer gender,String phone,String email);
}
