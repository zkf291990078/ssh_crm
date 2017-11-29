package com.anywell.dao;

import com.anywell.domain.User;

public interface UserDao {
  User getUserByCode(String code);
  void save(User user);
}
