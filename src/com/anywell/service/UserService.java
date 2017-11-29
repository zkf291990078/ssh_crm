package com.anywell.service;

import com.anywell.domain.User;

public interface UserService {
	User getUserByCodePassword(User user);

	void save(User u);
}
