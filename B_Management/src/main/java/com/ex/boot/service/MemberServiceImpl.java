package com.ex.boot.service;

import java.util.List;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Member> getMemberList() {
		List<Member> memberList = memberDao.getMemberList(); 
		return memberList;
	}

	@Override
	public void createMember(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMember(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(String userId) {
		// TODO Auto-generated method stub
		
	}

	
}
