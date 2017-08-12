package cn.transfer.service;

import java.util.List;

import cn.transfer.model.User;

public interface UserService {

	public User findUserById(Integer id) throws Exception;

	public List<User> findUsers(Integer id) throws Exception;

	public void updateUsers(Integer id, User user);
}
