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
public class LoginController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody List<Member> login(HttpServletRequest request, HttpServletResponse response){
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		
		boolean exist = memberService.existMember(userId, pwd);
		
		if(exist == true){
			Member getMember = memberService.getMember(userId);
			List<Member> member = new ArrayList<Member>();
			member.add(getMember);
			return member;
		}else{
			return null;
		}
		
		
	}
	
}
