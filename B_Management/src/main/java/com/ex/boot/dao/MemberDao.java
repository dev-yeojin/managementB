package com.ex.boot.dao;

import java.util.List;
import java.util.Map;

import com.ex.boot.vo.Member;


public interface MemberDao {
	
	public List<Member> selectMemberList() throws Exception;
	public Member selectMember(String userId) throws Exception;
	
	public int existUser(String userId) throws Exception;
	public int checkPassword(Map loginInfo) throws Exception;
	public int insertMember(Member member) throws Exception;
	public int updateMember(Member member) throws Exception;
	public int deleteMember(String userId) throws Exception;
	
	public int updateUserAuth(Map authInfo) throws Exception;
	
	public int deleteTest(String userId) throws Exception;
	
}
