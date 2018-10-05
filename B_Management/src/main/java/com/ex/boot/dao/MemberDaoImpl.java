package com.ex.boot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;

import com.ex.boot.vo.Member;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao{

	@Autowired
	@Qualifier("firstSqlSessionTemplate")
	private SqlSession sqlSession;
	
	@Autowired
	@Qualifier("firstTransactionManager")
	private DataSourceTransactionManager transactionManager;
	
	private static String namespace="com.ex.boot.mapper.MemberMapper";
	
	@Override
	public List<Member> selectMemberList() throws Exception{
		return sqlSession.selectList(namespace + ".selectMemberList");
	}
	@Override
	public Member selectMember(String userId) throws Exception{
		return (Member)sqlSession.selectOne(namespace + ".selectMember" , userId);
	}

	@Override
	public int existUser(String userId) throws Exception{
		return sqlSession.selectOne(namespace + ".existUser" , userId);
	}
	
	@Override
	public int checkPassword(Map loginInfo) throws Exception{
		return sqlSession.selectOne(namespace + ".checkPassword" , loginInfo);
	}

	@Override
	public int insertMember(Member member) throws Exception{
		
		return sqlSession.insert(namespace + ".insertMember", member);
	}

	@Override
	public int updateMember(Member member) throws Exception{
		return sqlSession.update(namespace + ".updateMember", member);
	}

	@Override
	public int deleteMember(String userId) throws Exception{
		return sqlSession.delete(namespace + ".deleteMember",userId);
	}
	

	@Override
	public int updateUserAuth(Map authInfo) throws Exception{
		return sqlSession.update(namespace + ".updateUserAuth", authInfo);
	}
	
	@Override
	public int deleteTest(String userId) throws Exception{
		return sqlSession.delete(namespace + ".deleteTest",userId);
	}
	
}
