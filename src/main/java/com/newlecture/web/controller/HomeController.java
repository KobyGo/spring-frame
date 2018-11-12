package com.newlecture.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.entity.Member;
import com.newlecture.web.service.DefaultViewManagementService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private DefaultViewManagementService service;
	
	 @GetMapping("index")
	 public String index() {
		 return "home.index";
	 }
	 
	 @PostMapping("service")
	 public String service(
			 Member member,
			 String action,
			 @RequestParam(name="menu-id", required=false) String[] menuIds) {
		/*
		 * Principal principal : 사용자 정보, 페이지 정보, 등등 보안 관련 등이 담겨져 있음
		 * 
		 * add,reg,insert 등 여러개가 잇는데
		 * 계층별로 맞추는게 더 좋다 
		 * 의인화~ 자연어로!
		 * 그래서 서비스는 add로~
		 */		 
		 
		switch (action) {
		case "add":
			service.addMember(member);
			break;
		case "list":
			service.getMemberList();
			break;
		default:
			break;
		}
		 
		 return "redirect:service";
	 }
}
