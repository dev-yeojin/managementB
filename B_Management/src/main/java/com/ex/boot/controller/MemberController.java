package com.ex.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ex.boot.service.MemberService;
import com.ex.boot.vo.Member;


@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	//member select
	@RequestMapping(value="/member",method=RequestMethod.GET)
	public @ResponseBody List<Member> getMember(HttpServletRequest request){
		String userId = request.getParameter("userId");
		
		Member getMember = memberService.getMember(userId);
		List<Member> member = new ArrayList<Member>();
		member.add(getMember);
		return member;
	}
	
	//Member select
	@RequestMapping(value="/member/memberList",method=RequestMethod.GET)
	public @ResponseBody List<Member> getMemberList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Member> memberList = memberService.getMemberList();
		return memberList;
	}
	
	//member create
	@RequestMapping(value="/member",method=RequestMethod.POST)
	public @ResponseBody void createMember(HttpServletRequest request){
		Member member = new Member();
		
		member.setUserId(request.getParameter("userId"));
		member.setPwd(request.getParameter("pwd"));
		member.setName(request.getParameter("name"));
		
		memberService.createMember(member);
	}
	
	//member edit
	@RequestMapping(value="/member",method=RequestMethod.PUT)
	public @ResponseBody void editMember(HttpServletRequest request){
		Member member = new Member();
		
		member.setUserId(request.getParameter("userId"));
		member.setPwd(request.getParameter("pwd"));
		member.setName(request.getParameter("name"));
		
		memberService.updateMember(member);
	}
	
	//member delete
	@RequestMapping(value="/member/delete",method=RequestMethod.POST)
	public @ResponseBody void deleteMember(HttpServletRequest request){
		String userId = request.getParameter("userId");
		memberService.deleteMember(userId);
	}
	
	//member 권한 수정
	@RequestMapping(value="/member/userAuth",method=RequestMethod.PUT)
	public @ResponseBody void updateUserAuth(HttpServletRequest request){
		String userId = request.getParameter("userId");
		Integer auth = Integer.parseInt(request.getParameter("auth"));
		
		memberService.updateUserAuth(userId, auth);
		
	}
	
}
