package com.ex.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ex.boot.vo.Member;


public interface MemberDao {
	
	public List<Member> getMemberList();

	
}
