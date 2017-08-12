package cn.transfer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.transfer.mapper.UserMapper;
import cn.transfer.model.User;
import cn.transfer.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	public User findUserById(Integer id) throws Exception {
		User user = userMapper.selectByPrimaryKey(id);

		return user;
	}

	public List<User> findUsers(Integer id) throws Exception {
		List<User> users = userMapper.selectByExample(null);
		return users;
	}

	@Override
	public void updateUsers(Integer id, User user) {
		user.setId(id);
		userMapper.updateByPrimaryKey(user);
	}

}
