package com.springboot.androidapp.security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.androidapp.security.model.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, String> {
	
	
	Member findByMememail(String mememail);

}