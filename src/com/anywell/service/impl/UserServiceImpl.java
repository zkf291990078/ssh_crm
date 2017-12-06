package com.anywell.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anywell.dao.UserDao;
import com.anywell.domain.User;
import com.anywell.service.UserService;

@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Override
	public User getUserByCodePassword(User user) {
		// TODO Auto-generated method stub
		User exitUser = userDao.getUserByCode(user.getUser_code());
		if (exitUser == null) {
			throw new RuntimeException("用户不存在");
		}
		if (!exitUser.getUser_password().equals(user.getUser_password())) {
			throw new RuntimeException("密码错误");
		}
		return exitUser;
	}

	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
	public void save(User u) {
		// TODO Auto-generated method stub
		User exitUser = userDao.getUserByCode(u.getUser_code());
		if (exitUser != null) {
			throw new RuntimeException("用户已存在");
		}
		userDao.save(u);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
