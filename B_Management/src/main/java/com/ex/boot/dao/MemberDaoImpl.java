package com.ex.boot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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
	public List<Member> selectMemberList() {
		return sqlSession.selectList(namespace + ".selectMemberList");
	}
	@Override
	public Member selectMember(String userId) {
		return (Member)sqlSession.selectOne(namespace + ".selectMember" , userId);
	}
	/*@Override
	public Member selectMember(String userId) {
		return sqlSession.selectOne(namespace + ".selectMember" , userId);
	}*/

	@Override
	public int existMember(Map loginInfo) {
		return sqlSession.selectOne(namespace + ".existMember" , loginInfo);
	}

	@Override
	public int insertMember(Member member) {
		/*DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("example-transaction");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = transactionManager.getTransaction(def);
		
		try {
			sqlSession.insert(namespace + ".insertMember", member);
		} catch (Exception e) {
			transactionManager.rollback(status);
			throw e;
		}*/
		return sqlSession.insert(namespace + ".insertMember", member);
	}

	@Override
	public int updateMember(Member member) {
		return sqlSession.update(namespace + ".updateMember", member);
	}

	@Override
	public int deleteMember(String userId) {
		return sqlSession.delete(namespace + ".deleteMember",userId);
	}
	

	@Override
	public int updateUserAuth(Map authInfo) {
		return sqlSession.update(namespace + ".updateUserAuth", authInfo);
	}
}
