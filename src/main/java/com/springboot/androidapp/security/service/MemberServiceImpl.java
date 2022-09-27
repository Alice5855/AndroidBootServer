package com.springboot.androidapp.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.androidapp.security.model.Member;
import com.springboot.androidapp.security.repository.MemberRepository;


@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberRepository repo;
	
	
	@Override
	public Member select(Member vo) {
		Member member = repo.findByMememail(vo.getMememail());
		return member;
	}

}