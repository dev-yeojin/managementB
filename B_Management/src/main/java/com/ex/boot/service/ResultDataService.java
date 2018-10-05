package com.ex.boot.service;

import java.util.List;

import com.ex.boot.controller.result.ResultMsg;
import com.ex.boot.exception.DbException;
import com.ex.boot.vo.Member;

public interface ResultDataService {
	String jsonResponse(ResultMsg msg, Member member, List<Member> memberList);
}