package com.np.wearound.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.np.wearound.dto.FeedDTO;

public interface FeedPageService {
	//피드목록 출력
	public List<FeedDTO> feedList() 
			throws ServletException, IOException;
	
	//아이디별피드목록 출력
	public List<FeedDTO> feedListById(String userid)
			throws ServletException, IOException;
	
	
	//좋아요처리
	
	//피드 댓글목록 출력
	
	//피드 댓글입력
	
	//피드 댓글 삭제
}
