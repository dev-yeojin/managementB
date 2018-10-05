package com.ex.boot.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.ex.boot.controller.result.ResultMsg;
import com.ex.boot.vo.Member;
import com.ex.boot.vo.ResponseData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service("resultDataService")
public class ResultDataServiceImpl implements ResultDataService{
	
	private Gson gson =  new GsonBuilder().serializeNulls().create();
	
	public String jsonResponse(ResultMsg msg, Member member, List<Member> memberList){
		ResponseData response = new ResponseData(msg,member,memberList);
		return gson.toJson(response);
	};
}