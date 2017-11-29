package com.anywell.service;

import org.apache.catalina.User;

public interface UserService {
	User getUserByCodePassword(User user);
}
