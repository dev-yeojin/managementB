package com.ex.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ex.boot.controller.result.ResultMsg;
import com.ex.boot.exception.DbException;
import com.ex.boot.service.MemberService;
import com.ex.boot.service.ResultDataService;
import com.ex.boot.vo.Member;


@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private ResultDataService resultDataService;
	
	//member select
	@RequestMapping(value="/member",method=RequestMethod.GET)
	public @ResponseBody String getMember(HttpServletRequest request){
		String userId = request.getParameter("userId");
		try {
			Member member = memberService.getMember(userId);
			return resultDataService.jsonResponse(ResultMsg.SUCCESS, member, null);
		} catch (Exception e) {
			return resultDataService.jsonResponse(ResultMsg.ERROR, null, null);
		}
	}
	
	//Member select
	@RequestMapping(value="/member/memberList",method=RequestMethod.GET)
	public @ResponseBody String getMemberList(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Member> memberList = memberService.getMemberList();
			return resultDataService.jsonResponse(ResultMsg.SUCCESS, null, memberList);
		} catch (Exception e) {
			return resultDataService.jsonResponse(ResultMsg.ERROR, null, null);
		}
	}
	
	//member create
	@RequestMapping(value="/member",method=RequestMethod.POST)
	public @ResponseBody String createMember(HttpServletRequest request) {
		Member member = new Member();
		
		member.setUserId(request.getParameter("userId"));
		member.setPwd(request.getParameter("pwd"));
		member.setName(request.getParameter("name"));
		try {
			boolean exist = memberService.existUser("userId");
			memberService.createMember(member);
			return resultDataService.jsonResponse(ResultMsg.SUCCESS, null, null);	
		} catch (Exception e) {
			return resultDataService.jsonResponse(ResultMsg.ERROR, null, null);
		}
	}
	
	//member edit
	@RequestMapping(value="/member",method=RequestMethod.PUT)
	public @ResponseBody String editMember(HttpServletRequest request){
		Member member = new Member();
		
		member.setUserId(request.getParameter("userId"));
		member.setPwd(request.getParameter("pwd"));
		member.setName(request.getParameter("name"));
		
		try {
			memberService.updateMember(member);
			return resultDataService.jsonResponse(ResultMsg.SUCCESS, null, null);
		} catch (Exception e) {
			return resultDataService.jsonResponse(ResultMsg.ERROR, null, null);
		}
	}
	
	//member delete
	@RequestMapping(value="/member/delete",method=RequestMethod.POST)
	public @ResponseBody String deleteMember(HttpServletRequest request){
		String userId = request.getParameter("userId");
		
		try {
			memberService.deleteMember(userId);
			return resultDataService.jsonResponse(ResultMsg.SUCCESS, null, null);
		} catch (Exception e) {
			return resultDataService.jsonResponse(ResultMsg.ERROR, null, null);
		}
	}
	
	//member 권한 수정
	@RequestMapping(value="/member/userAuth",method=RequestMethod.PUT)
	public @ResponseBody String updateUserAuth(HttpServletRequest request){
		String userId = request.getParameter("userId");
		Integer auth = Integer.parseInt(request.getParameter("auth"));
		
		try {
			memberService.updateUserAuth(userId, auth);
			return resultDataService.jsonResponse(ResultMsg.SUCCESS, null, null);
		} catch (Exception e) {
			return resultDataService.jsonResponse(ResultMsg.ERROR, null, null);
		}
	}
}
