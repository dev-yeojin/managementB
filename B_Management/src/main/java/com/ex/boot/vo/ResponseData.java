package com.ex.boot.vo;

import java.util.List;

import com.ex.boot.controller.result.ResultMsg;

public class ResponseData {

	private ResultMsg msg;
	private Member member;
	private List<Member> memberList;
	
	
	public ResultMsg getMsg() {
		return msg;
	}

	public void setMsg(ResultMsg msg) {
		this.msg = msg;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

	public ResponseData(){
		super();
	}
	
	public ResponseData(ResultMsg msg, Member member, List<Member> memberList){
		this.msg = msg;
		this.member = member;
		this.memberList = memberList;
	}

	
}
