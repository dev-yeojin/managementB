package com.ex.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ex.boot.vo.Member;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {
	
	
	@Override
	public boolean existMember(String userId, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Member> getMemberList() {
		// TODO Auto-generated method stub
		return null;
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
