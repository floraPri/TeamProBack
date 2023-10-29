package com.np.wearound.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.np.wearound.dto.FeedDTO;
import com.np.wearound.entities.FeedComment;

public interface FeedPageService {
	//피드목록 출력
	public List<FeedDTO> feedList() 
			throws ServletException, IOException;
	
	//아이디별피드목록 출력
	public List<FeedDTO> feedListById(String userid)
			throws ServletException, IOException;
	
	//피드 댓글목록 출력
	public List<FeedComment> commentList(int feedcode);
	
	//피드 댓글입력
	public void insertComment(FeedComment feedComment);
	
	//피드 댓글 삭제
	public void deleteCommnet(int commentno);
	
	//좋아요처리
	
	
	

}
