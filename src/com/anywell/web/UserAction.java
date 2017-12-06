package com.anywell.web;

import com.anywell.domain.User;
import com.anywell.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() throws Exception {
		// TODO Auto-generated method stub
		User u = userService.getUserByCodePassword(user);
		ActionContext.getContext().getSession().put("user", u);
		return "toHome";
	}
	
	public String regist() throws Exception {
		// TODO Auto-generated method stub
		try {
			userService.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		return "login";
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
