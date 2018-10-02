package com.ex.boot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.boot.dao.MemberDao;
import com.ex.boot.vo.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	
	@Override
	public boolean existMember(String userId, String pwd) {
		Map<String, String> loginInfo = new HashMap<String, String>();
		loginInfo.put("userId", userId);
		loginInfo.put("pwd", pwd);
		
		int count = memberDao.existMember(loginInfo);
		if(count == 1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Member getMember(String userId) {
		Member member = memberDao.selectMember(userId);
		return member;
	}
	
	@Override
	public List<Member> getMemberList() {
		List<Member> memberList = memberDao.selectMemberList(); 
		return memberList;
	}

	@Override
	public void createMember(Member member) {
		member.setAuth(3);
		memberDao.insertMember(member);
	}

	@Override
	public void updateMember(Member member) {
		memberDao.updateMember(member);
	}

	@Override
	public void deleteMember(String userId) {
		memberDao.deleteMember(userId);
	}
	
	@Override
	public void updateUserAuth(String userId, int auth) {
		Map authInfo = new HashMap<>();
		
		authInfo.put("userId", userId);
		authInfo.put("auth",auth);
		
		memberDao.updateUserAuth(authInfo);		
	}
}
