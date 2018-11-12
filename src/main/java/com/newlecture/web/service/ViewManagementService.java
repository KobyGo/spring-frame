package com.newlecture.web.service;

import java.util.List;

import com.newlecture.web.entity.Member;

public interface ViewManagementService {
	public List<Member> getMemberList();
	public int addMember(Member ember);
}
