package com.springboot.androidapp.service;

import com.springboot.androidapp.model.User;

public interface UserService {

	void insert(User vo);

	User select(User vo);

}