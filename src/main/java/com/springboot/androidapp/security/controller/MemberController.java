package com.springboot.androidapp.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.androidapp.security.model.Member;
import com.springboot.androidapp.security.service.MemberService;


// RESTful API 처리를 위한 애노테이션 설정
@RestController
public class MemberController {
	@Autowired
	private MemberService service;

	// @RequestBody 는 HttpServletRequest request(요청) 사항의 Body 전송 데이터를 자바 객체로 변환할 때 사용함.
    // 참고로, @ResponseBody 의 경우, 자바 객체를 HttpServletResponse response(응답) 사항의 Body 전송 데이터로 변환할 때 사용함.
	@RequestMapping(value = "/signin")
	public boolean signIn(@RequestBody Member vo, HttpServletRequest request) {
		Member member;
		try {
			member = service.select(vo);
		} catch (NullPointerException e) {
			member = null;
		}
		if(member != null) {
			if (member.getMempw().equals(vo.getMempw())) {
				return true;
			}
		}
		return false;
	}
	
}