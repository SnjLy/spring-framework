package com.snjly.spring.demo.service;

import com.snjly.spring.demo.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author : LiuYong at 2019-10-18
 * @package: com.snjly.spring.demo.service
 */
@Service
public class UserService {

	public UserModel getUser(Integer id){
		UserModel userModel = new UserModel();
		userModel.setId(id);
		userModel.setUserId(UUID.randomUUID().toString());
		return userModel;
	}
}
