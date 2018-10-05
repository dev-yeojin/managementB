package com.ex.boot.service;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.boot.dao.MemberDao;
import com.ex.boot.vo.Member;

@Service("memberService")
@Transactional("firstTransactionManager")
//@Transactional(rollbackFor=InvalidParameterMyException.class) // RuntimeException을 상속받지 않은 Exception 클래스를 트랜잭션할 수 있도록 하기 위한 애노테이션
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao memberDao;
	private int baseUserAuth = 3;

	   
	@Override
	public boolean existUser(String userId) throws Exception{
		int count = memberDao.existUser(userId);
	
		if(count == 1){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public boolean checkPassword(String userId, String pwd) throws Exception{
		Map<String, String> loginInfo = new HashMap<String, String>();
		loginInfo.put("userId", userId);
		loginInfo.put("pwd", encryptPwd(userId,pwd));
		
		int count = memberDao.checkPassword(loginInfo);
		
		if(count == 1){
			return true;
		}else{
			return false;
		}
	}
	

	@Override
	public Member getMember(String userId) throws Exception{
		Member member = memberDao.selectMember(userId);
		return member;
	}
	
	@Override
	public List<Member> getMemberList() throws Exception{
		List<Member> memberList = memberDao.selectMemberList(); 
		return memberList;
	}

	@Override
	public void createMember(Member member) throws Exception{
		member.setAuth(baseUserAuth);
		String userId = member.getUserId();
		String pwd = member.getPwd();
		
		member.setPwd(encryptPwd(userId,pwd));
		
		memberDao.insertMember(member);
	}

	@Override
	public void updateMember(Member member) throws Exception{
		member.setPwd(encryptPwd(member.getUserId(),member.getPwd()));
		memberDao.deleteMember(member.getUserId());
		memberDao.updateMember(member);
	}

	@Override
	public void deleteMember(String userId) throws Exception{
		memberDao.deleteMember(userId);
	}
	
	@Override
	public void updateUserAuth(String userId, int auth) throws Exception{
		Map authInfo = new HashMap<>();
		
		authInfo.put("userId", userId);
		authInfo.put("auth",auth);
		
		memberDao.updateUserAuth(authInfo);
	
	}

	private String encryptPwd(String userId, String pwd) {
		String saltedPwd = userId + pwd + userId ;
		try {
			MessageDigest msgDigest = MessageDigest.getInstance("SHA-256");
			byte[] hash = msgDigest.digest(saltedPwd.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
