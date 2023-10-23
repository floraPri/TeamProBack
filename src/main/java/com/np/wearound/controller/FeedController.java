package com.np.wearound.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.np.wearound.entities.Feed;
import com.np.wearound.service.MyPageServiceImpl;

@RestController
@RequestMapping(value="/myPage")
public class FeedController {
	private static final Logger logger = LoggerFactory.getLogger(FeedController.class);
	
	@Autowired
	private MyPageServiceImpl service;
	
	//내가 등록한 피드 목록
	@GetMapping("/myp")
	public List<Feed> feedList(@RequestParam int userno) 
			throws ServletException, IOException {
		logger.info("<<< MyPageController -  feedList(피드 마이페이지)>>>");
		System.out.println("고객 고유번호"+ userno);
		
		List<Feed> myFeedList = service.feedList(userno);
		System.out.println("FeedController");
		return myFeedList;
	}
	
}
