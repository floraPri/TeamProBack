package com.np.wearound.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.np.wearound.dto.FeedDTO;
import com.np.wearound.entities.FeedComment;
import com.np.wearound.service.FeedPageServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/feed")
public class FeedController {
	private static final Logger logger = LoggerFactory.getLogger(FeedController.class);

	//http://localhost:8081/feed/
	
	@Autowired
	private FeedPageServiceImpl service;
	
	
	//피드목록 페이지
	@GetMapping("/feedPage")
	public List<FeedDTO> feedList() 
			throws ServletException, IOException{
		logger.info("<<<< FeedController -  feedList(피드목록 출력)>>>>");
		System.out.println("컨트롤러 - 피드목록 출력");
		
		List<FeedDTO> feed_list = service.feedList();
		System.out.println("컨트롤러 - 피드 데이터 전송성공");
		return feed_list;
	}
	
	
	//등록회원별 목록 페이지
	@GetMapping("/feedListByIdPage")
	public List<FeedDTO> feedListByUserid(@RequestParam String userid) 
			throws ServletException, IOException {
		logger.info("<<<< FeedController -  feedList(아이디별 등록피드리스트 출력)>>>>");
		System.out.println("컨트롤러 - 피드목록 출력");
		
		List<FeedDTO> feed = service.feedListById(userid);
		
		System.out.println("컨트롤러 - 아이디별 피드데이터 전송성공");
		System.out.println("컨트롤러 - feed"+feed);
		return feed;
	}
	
	//피드 상세 1건 -> 고객들이 눌렀을때 피드 페이지로...
	public FeedDTO feedDetail(int feedcode) 
			throws ServletException, IOException {
		logger.info("<<<< FeedController -  feedList(아이디별 등록피드리스트 출력)>>>>");
		
		return null;
	}
	
	//피드 댓글목록 출력
	public List<FeedComment> feedCommentList(@RequestParam int feedcode) 
			throws ServletException, IOException {
		logger.info("<<<< FeedController -  feedList(피드댓글 목록 출력)  >>>>");	
		
		
		return null;
	}
	
}
