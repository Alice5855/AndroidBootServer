package com.springboot.androidapp.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "membertable")
@Getter
@Setter
@ToString
public class Member {
	@Id
	@Column(name = "memnum")
	private String memnum;
	@Column(name = "memnickname")
	private String memnickname;
	@Column(name = "mempw")
	private String mempw;
	@Column(name = "mememail")
	private String mememail;

}