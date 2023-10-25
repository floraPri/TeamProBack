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
public class FeedController {
	private static final Logger logger = LoggerFactory.getLogger(FeedController.class);
	
	@Autowired
	private MyPageServiceImpl service;
	
	
	//내가 등록한 피드 목록
	@GetMapping("/myp")
	public List<Feed> feedList(@RequestParam int userno) 
			throws ServletException, IOException {
		logger.info("<<< FeedController -  feedList(피드 마이페이지)>>>");
		System.out.println("고객 고유번호"+ userno);
		
		List<Feed> myFeedList = service.feedList(userno);
		System.out.println("FeedController");
		return myFeedList;
	}
	

	//피드 등록
	@PostMapping(value="/feedAdd", consumes="multipart/form-data")
	public String feedAdd(
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("image") MultipartFile image,
			@RequestParam("userno") int userno,
			HttpServletRequest req
			) 
		throws ServletException, IOException {
		logger.info("<<< FeedController -  feedAdd(피드 등록 페이지)>>>");
		
		FeedAddDTO dto = new FeedAddDTO();
		
		String upLoadDirectory = req.getSession().getServletContext().getRealPath("/images");
		System.out.println("upLoadDirectory : "+upLoadDirectory);
		
		if(!image.isEmpty()) {
			String fileName = image.getOriginalFilename();
			System.out.println("fileName => "+fileName);
			
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
		logger.info("<<< FeedController -  feedAdd(피드 삭제)>>>");
		
		System.out.println("feedcode : "+feedcode);
		
		service.delete(feedcode);
		System.out.println("Delete성공");
		return "redirect:/myPage/myp";
	}
	
	//피드 수정
	
	
	
	
	
	//피드 상세(select 1건)
	
}
