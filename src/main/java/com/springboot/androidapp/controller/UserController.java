package com.springboot.androidapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.androidapp.model.User;
import com.springboot.androidapp.service.UserService;

// RESTful API 처리를 위한 애노테이션 설정
@RestController
public class UserController {
	@Autowired
	private UserService service;

	// @RequestBody 는 HttpServletRequest request(요청) 사항의 Body 전송 데이터를 자바 객체로 변환할 때 사용함.
    // 참고로, @ResponseBody 의 경우, 자바 객체를 HttpServletResponse response(응답) 사항의 Body 전송 데이터로 변환할 때 사용함.
	@RequestMapping(value = "/signin")
	public boolean signIn(@RequestBody User vo, HttpServletRequest request) {
		User user;
		try {
			user = service.select(vo);
		} catch (NullPointerException e) {
			user = null;
		}
		if(user != null) {
			if (user.getUserPassword().equals(vo.getUserPassword())) {
				return true;
			}
		}
		return false;
	}
	
	@RequestMapping(value = "/signup")
	public boolean signUp(@RequestBody User vo) {
		System.out.println(vo);
		try {
			service.insert(vo);
			System.out.println(true);
			return true;
		} catch (Exception e) {
			System.out.println(false);
			return false;
		}
	}

}