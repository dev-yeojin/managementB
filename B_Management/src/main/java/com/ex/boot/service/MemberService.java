package com.ex.boot.service;

import java.util.*;

import com.ex.boot.vo.Member;

public interface MemberService {

	public boolean existMember(String userId, String pwd);
	
	public List<Member> getMemberList();
	public Member getMember(String userId);
	public void createMember(Member member);
	public void updateMember(Member member);
	public void deleteMember(String userId);
	
	public void updateUserAuth(String userId, int auth);
}
