package com.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dao.DBUtil;
import com.rest.model.DataSource;
import com.rest.model.User;
import com.rest.util.ApplicationContextProvider;
import com.rest.util.DataServiceConstants;

@RestController
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = DataServiceConstants.DUMMY_USR, method = RequestMethod.GET)
	public User getDummyUser(){
		DataSource dataSource = ApplicationContextProvider.getApplicationContext().getBean("datasource", DataSource.class);
		User user = new User();
		user.setUserName(dataSource.getDbName());
		user.setPassword(dataSource.getDbURL());
		return user;
	}
	
	@RequestMapping(value = DataServiceConstants.CREATE_USR, method = RequestMethod.POST)
	public User registerUser(@RequestBody User user){
		DBUtil.setUserDetails(user);
		return user;
	}
	
}
