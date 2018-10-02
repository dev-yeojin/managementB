package com.ex.boot.dao;

import java.util.List;
import java.util.Map;

import com.ex.boot.vo.Member;


public interface MemberDao {
	
	public List<Member> selectMemberList();
	public Member selectMember(String userId);
	
	public int existMember(Map loginInfo);
	public int insertMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(String userId);
	
	public int updateUserAuth(Map authInfo);
}
