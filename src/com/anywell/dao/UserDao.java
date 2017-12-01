package com.anywell.dao;

import com.anywell.domain.User;

public interface UserDao extends BaseDao<User> {
	User getUserByCode(String code);

}
