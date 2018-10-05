package com.ex.boot.controller;

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
public class LoginController {

	@Autowired
	MemberService memberService;
	@Autowired
	ResultDataService responseService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody String login(HttpServletRequest request, HttpServletResponse response){
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		String msg = null;
		
		try {
			boolean existUser = memberService.existUser(userId);
			if(existUser == true){
				boolean checkPwd = memberService.checkPassword(userId, pwd);
				if(checkPwd == true){
					Member member = memberService.getMember(userId);
					return responseService.jsonResponse(ResultMsg.LOGIN_SUCCESS, member, null);
				}else{
					return responseService.jsonResponse(ResultMsg.LOGIN_FAIL, null, null);
				}
			}else{
				return responseService.jsonResponse(ResultMsg.NOT_EXIST_USERID, null, null);
			}
		} catch (Exception e) {
			return responseService.jsonResponse(ResultMsg.ERROR, null, null);
		}
	}
}
