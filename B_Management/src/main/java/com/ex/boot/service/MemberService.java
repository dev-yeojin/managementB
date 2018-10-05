package com.ex.boot.service;

import java.util.List;

import com.ex.boot.vo.Member;

public interface MemberService {

	
	public boolean existUser(String userId) throws Exception;
	public boolean checkPassword(String userId, String pwd) throws Exception;
	
	public List<Member> getMemberList() throws Exception;
	public Member getMember(String userId) throws Exception;
	public void createMember(Member member) throws Exception;
	public void updateMember(Member member) throws Exception;
	public void deleteMember(String userId) throws Exception;
	
	public void updateUserAuth(String userId, int auth) throws Exception;
}
