package com.np.wearound.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.np.wearound.dto.FeedAddDTO;
import com.np.wearound.entities.Feed;
import com.np.wearound.service.MyPageServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/myPage")
public class MyPageFeedController {
	private static final Logger logger = LoggerFactory.getLogger(MyPageFeedController.class);
	
	@Autowired
	private MyPageServiceImpl service;

	@GetMapping("/myp")
	public List<Feed> feedList(@RequestParam int userno) 
			throws ServletException, IOException {
		List<Feed> myFeedList = service.feedList(userno);
		return myFeedList;
	}
	
	@PostMapping(value="/feedAdd", consumes="multipart/form-data")
	public String feedAdd(
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("image") MultipartFile image,
			@RequestParam("userno") int userno,
			HttpServletRequest req) 
		throws ServletException, IOException {		
		FeedAddDTO dto = new FeedAddDTO();
		
		String upLoadDirectory = req.getSession().getServletContext().getRealPath("/images");
		
		if(!image.isEmpty()) {
			String fileName = image.getOriginalFilename();
			File uploadFile = new File(fileName);
			String fullPath = upLoadDirectory + File.separator + uploadFile;
			image.transferTo(new File(fullPath));
			String filePath = "http://localhost:8081/images/"+uploadFile;
			
			dto.setImage(filePath);
		}
		
		dto.setUserno(userno);
		dto.setTitle(title);
		dto.setContent(content);
		
		service.saveFeed(dto);
		
		return "redirect:/myPage/myp";
	}
	
	//피드 삭제
	@DeleteMapping("/myp/{feedcode}")
	public String feedDelete(@PathVariable(name="feedcode") int feedcode) 
			throws ServletException, IOException {
		service.delete(feedcode);
		return "redirect:/myPage/myp";
	}
	
	//피드 상세(select 1건)
	@GetMapping(value="/feedEditPage")
	public Feed fetchFeedById(@RequestParam("feedcode") int feedcode) 
			throws ServletException, IOException {
		Feed feed = service.findById(feedcode);
		return feed;
	}
	
	//피드 수정
	@PostMapping(value="/feedEditPage", consumes="multipart/form-data")
	public String feedEdit(
			@RequestParam("feedcode") int feedcode,
			@RequestParam("feedtitle") String title,
			@RequestParam("feedcontent") String content,
			@RequestParam("image") MultipartFile image,
			@RequestParam("userno") int userno,
			HttpServletRequest req) throws ServletException, IOException {

		String upLoadDirectory = req.getSession().getServletContext().getRealPath("/images");
		FeedAddDTO dto = new FeedAddDTO();
		
		if(!image.isEmpty()) {
			String fileName = image.getOriginalFilename();
			// 저장할 파일 경로
			File uploadedFile = new File(fileName);
			String fullPath = upLoadDirectory + File.separator + uploadedFile;
			image.transferTo(new File(fullPath));
			String filePath = "http://localhost:8081/images/"+uploadedFile+"/";
			dto.setImage(filePath);
		}
		
		dto.setFeedcode(feedcode);
		dto.setUserno(userno);
		dto.setTitle(title);
		dto.setContent(content);
				
		service.updateFeed(dto);
		
		return "redirect:/myPage/myp";
	} 
	
	//마이페이지 => 나의 채널 : 내가 등록한 피드 목록
	@GetMapping("/myChannel")
	public List<Feed> myChannelfeedList(@RequestParam int userno) 
			throws ServletException, IOException {
		List<Feed> myFeedList = service.feedList(userno);
		return myFeedList;
	}
}











//		logger.info("<<< MyPageFeedController -  feedEdit(피드 수정)>>>");
//		logger.info("<<< MyPageFeedController -  fetchFeedById(피드 상세)>>>");
//		logger.info("fileName fullPath={}", fileName);
//		logger.info("<<< MyPageFeedController -  myChannelfeedList(마이채널 피드 목록)>>>");	
//		logger.info("<<< FeedController -  feedAdd(피드 삭제)>>>");	
// 		logger.info("<<< MyPageFeedController -  feedList(피드 마이페이지)>>>");		
//		logger.info("<<< MyPageFeedController -  feedAdd(피드 등록 페이지)>>>");