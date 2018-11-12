package com.newlecture.web.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;

@Repository
public class HibernateMemberDao implements MemberDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional //Hiberante는 sql실행할때 꼭 꼭 해줘야함 
	public int insert(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Member member) {
		Session session = sessionFactory.getCurrentSession();
		
		Object id = session.save(member);
		if(id != null)
			return 1;
		
		return 0;
	}

	@Override
	@Transactional
	public int delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		
		Member member = new Member();
		member.setId(id);
		
		session.remove(member);
		
		return 0;
	}

	@Override
	@Transactional
	public Member get(String id) {
		Session session = sessionFactory.getCurrentSession();
		
		Member member = session.get(Member.class,id);
		
		return member;
	}

	@Override
	@Transactional
	public List<Member> getList() {
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "from Member";
		
		List<Member> list = session
								.createQuery(hql, Member.class)
								.getResultList();
		return list;
	}

	@Override
	public List<Member> getList(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getList(String field, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getList(String field, String name, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
