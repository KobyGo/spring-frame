package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;

@Service
public class DefaultViewManagementService implements ViewManagementService{

	/*
	 * 물리 아키텍쳐
	 * 서비스는 시스템 기반으로 구성해야한다.
	 * 시스템은 체계이다.
	 * 
	 * 업무 절차 = 업무 시스템
	 * 업무는 액터가 하는 행위
	 * 
	 * [아키텍처 최강자가 마이크로]
	 */
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public List<Member> getMemberList() {
		return memberDao.getList();
	}

	@Override
	public int addMember(Member member) {
		
		int result = memberDao.insert(member);
		
		return result;
	}
}
